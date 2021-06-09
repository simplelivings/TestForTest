package openCV;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-05-20 15:02
 */

public class OpenCVUtils {


    //连接openCV库
    public static void loadOpenCV(){
        URL url = ClassLoader.getSystemResource("lib/opencv_java452.dll");
        System.load(url.getPath());
    }

    /**
     * Mat图像转换为BufferedImage
     *
     * @param mat s数据图像
     * @return BufferedImage
     */
    public static BufferedImage toBufferedImage(Mat mat) {
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer);//获取所有像素点
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return image;
    }

    /**
     * 将BufferedImage内存图像保存为图像文件
     *
     * @param bImage   BufferedImage
     * @param filePath 文件名
     */
    public static void saveJpgImage(BufferedImage bImage, String filePath) {
        try {
            ImageIO.write(bImage, "jpg", new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * 找到指定半径范围的唯一圆,遍历后remove，不会发生recurrent报错
     * @param contours 轮廓List
     * @param minRadius 最小圆半径
     * @param maxRadius 最大圆半径
     * @return circles 返回圆的集合
     */
    public static List<Circle> findCircles(List<MatOfPoint> contours, int minRadius, int maxRadius) {
        List<Circle> circles = new ArrayList<Circle>();
        for (int i = 0; i < contours.size(); i++) {
            MatOfPoint2f approxCurve = new MatOfPoint2f();
            Point center = new Point();
            float[] radius = new float[10];

            /*
             * 以指定的精度最大化接近多边形曲线。
             * 函数cv :: approxPolyDP用一条具有较少顶点的曲线或多边形最大化接近一条曲线或多边形，以使它们之间的距离小于或等于指定的精度。
             * 它使用Douglas-Peucker算法<http://en.wikipedia.org/wiki/Ramer-Douglas-Peucker_algorithm>
             * @param curve存储在std :: vector或Mat中的2D点的输入向量
             * @param roxCurve近似结果。 类型应与输入曲线的类型匹配。
             * @param epsilon指定近似精度的参数。 这是原始曲线与其近似值之间的最大距离。
             * @param 闭合如果为true，则近似曲线将闭合（其第一个和最后一个顶点已连接）。 否则，它不会关闭。
             */
            Imgproc.approxPolyDP(new MatOfPoint2f(contours.get(i).toArray()), approxCurve, 0.1, true);

            Imgproc.minEnclosingCircle(approxCurve, center, radius);

            if (((int) radius[0] > minRadius) && ((int) radius[0] < maxRadius)) {
                Circle circle = new Circle();
                circle.setCenter(center);
                circle.setRadius((int) radius[0]);
                circles.add(circle);
            }
        }
        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                int absX = (int)Math.abs(circles.get(i).getCenter().x - circles.get(j).getCenter().x);
                int absY = (int)Math.abs(circles.get(i).getCenter().y -  circles.get(j).getCenter().y);
                if (absX < 0.5 && absY < 0.5) {
                    circles.remove(circles.get(i));
                }
            }
        }
        return circles;
    }

    /**
     * 找到指定宽度与高度范围内的矩形
     * @param contours 轮廓线集合
     * @param minWidth 最小宽度
     * @param maxWidth 最大宽度
     * @param minHeight 最小高度
     * @param maxHeight 最大高度
     * @return rectList 反馈矩形集合
     */
    public static List<Rect> findRects(List<MatOfPoint> contours,int minWidth, int maxWidth, int minHeight, int maxHeight) {
        List<MatOfPoint> approxCurveList = new ArrayList<MatOfPoint>();
        List<Rect> rectList = new ArrayList<Rect>();
        for (int i = 0, size = contours.size(); i < size; i++) {

            MatOfPoint2f approxCurve = new MatOfPoint2f();
            Point center = new Point();
            float[] radius = new float[10];

            /*
             * 以指定的精度最大化接近多边形曲线。
             * 函数cv :: approxPolyDP用一条具有较少顶点的曲线或多边形最大化接近一条曲线或多边形，以使它们之间的距离小于或等于指定的精度。
             * 它使用Douglas-Peucker算法<http://en.wikipedia.org/wiki/Ramer-Douglas-Peucker_algorithm>
             * @param curve存储在std :: vector或Mat中的2D点的输入向量
             * @param roxCurve近似结果。 类型应与输入曲线的类型匹配。
             * @param epsilon指定近似精度的参数。 这是原始曲线与其近似值之间的最大距离。
             * @param 闭合如果为true，则近似曲线将闭合（其第一个和最后一个顶点已连接）。 否则，它不会关闭。
             */
            Imgproc.approxPolyDP(new MatOfPoint2f(contours.get(i).toArray()), approxCurve, 0.1, true);
            approxCurveList.add(new MatOfPoint(approxCurve.toArray()));


            /*
             * 计算点集或灰度图像的非零像素的右边界矩形。 该函数为指定的点集或灰度图像的非零像素计算并返回最小的垂直边界矩形。
             * @param数组输入存储在std :: vector或Mat中的灰度图像或2D点集。
             */
            Rect boundRect = Imgproc.boundingRect(approxCurve);
            int width = boundRect.width;
            int height = boundRect.height;
            if (width > minWidth && width < maxWidth && height > minHeight && height < maxHeight){
                rectList.add(boundRect);
            }
        }

        return rectList;
    }


    /**
     * 找到二值图像上，大于指定像素值的所有点
     * @param uc1Mat 单通道Mat
     * @param threshold 阈值
     * @return points 点集合
     */
    public static ArrayList<Point> findAllPoints(Mat uc1Mat, int threshold) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < uc1Mat.rows(); i++) {
            for (int j = 0; j < uc1Mat.cols(); j++) {
                if (uc1Mat.channels() == 1) {
                    if (uc1Mat.get(i, j)[0] > threshold) {
                        Point p = new Point(j, i);
                        points.add(p);
                    }
                }
            }
        }

        System.out.println("pointsSize=" + points.size());
        return points;
    }


    /**
     * 找到二值图像上，指定范围内，大于指定像素值的所有点
     * @param uc1Mat 单通道Mat
     * @param threshold 阈值
     * @param row 距离原点的行数
     * @param col 距离原点的列数
     * @return
     */
    public static ArrayList<Point> findRangePoints(Mat uc1Mat, int threshold, int row, int col) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (uc1Mat.channels() == 1) {
                    if (uc1Mat.get(i, j)[0] > threshold) {
                        Point p = new Point(j, i);
                        points.add(p);
                    }
                }
            }
        }
        return points;
    }

    /**
     * 找到距离某个点，直线距离最短的点
     * @param points 点的集合
     * @param x 参照点x坐标
     * @param y 参照点y坐标
     * @return point 返回点
     */
    public static Point findMinDistancePoint(ArrayList<Point> points, int x, int y) {
        int index = 0;
        double k = 1000000;

        for (int i = 0; i < points.size(); i++) {
            double distance = Math.pow(points.get(i).x - x, 2.0) + Math.pow(points.get(i).y - y, 2);
            if (distance < k) {
                k = distance;
                index = i;
            }
        }
        return points.get(index);
    }

}
