package openCV;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.*;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-06-08 13:48
 */

public class Camera01 {
    public static void main(String[] args) {

        String path = "D:\\nut2.jpg";
        double prop = 0.5;
        int height = 0, width = 0, rows = 0, cols = 0; //resize后的图片尺寸
        int thresh = 150, maxVal = 250; //二值化阈值
        int eHeight = 3, eWidth = 3; //膨胀卷积核尺寸
        int dIteration = 1, eIteration = 1;//膨胀和腐蚀的迭代次数
        int cThreshold1 = 3, cThreshold2 = 3, apertureSize = 5; //边缘阈值与间隙尺寸
        int minRadius = 10, maxRadius = 25; //查找圆直径范围
        Scalar contoursColor = new Scalar(150, 5, 50, 50);//轮廓线颜色
        Scalar circleColor = new Scalar(0, 0, 220); //圆边线颜色；
        int contoursThick = 2, circleThick = 2; //轮廓及圆的厚度, 圆的厚度负值为实心圆
        Mat image, resizeImage, grayImage, bImage, dilateMat, erodeMat, cannyMat, hImage;

        //1 连接openCV库
        OpenCVUtils.loadOpenCV();

        //2 读取图片
        image = imread(path, 1);

        if (image != null) {
            //3 调整图片尺寸
            resizeImage = new Mat();
            Imgproc.resize(
                    image, resizeImage, new Size(image.cols() * prop, image.rows() * prop),
                    0, 0, Imgproc.INTER_AREA);

            cols = resizeImage.cols();
            rows = resizeImage.cols();

            //4 灰度处理
            grayImage = new Mat();
            cvtColor(resizeImage, grayImage, Imgproc.COLOR_BGR2GRAY);


            //5 二值处理
            bImage = new Mat(height, width, CvType.CV_8UC1);
            Imgproc.threshold(grayImage, bImage, thresh, maxVal, Imgproc.THRESH_BINARY);


/*        //6.1 形态操作-图像膨胀-可选
        Mat dilateMat = new Mat();
        Mat element = Imgproc.getStructuringElement(
                Imgproc.MORPH_RECT, new Size(eWidth, eHeight), new Point(-1, -1));
        Imgproc.dilate(
                bImage, dilateMat, element, new Point(-1, -1), dIteration);

        //6.2 形态操作-图像腐蚀-可选
        Mat erodeMat = new Mat();
        Imgproc.erode(dilateMat, erodeMat, element, new Point(-1, -1), eIteration);
        imshow("erodeMat", erodeMat);*/

            //7 获取图像边缘-可选
            cannyMat = new Mat();
            Imgproc.Canny(bImage, cannyMat, cThreshold1, cThreshold2, apertureSize, true);

            //8 获取图像轮廓
            List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
            hImage = new Mat();
            Imgproc.findContours(cannyMat, contours, hImage, RETR_LIST,
                    Imgproc.CHAIN_APPROX_SIMPLE, new Point(0, 0));
            for (int i = 0; i < contours.size(); i++) {
                Imgproc.drawContours(resizeImage, contours, i, contoursColor, contoursThick);
            }

            //9 找到圆的轮廓
            List<Circle> circleList = OpenCVUtils.findCircles(contours, minRadius, maxRadius);

            //10找到矩形轮廓
            List<Rect> rectList = OpenCVUtils.findRects(contours,100,150,100,150);
            List<Rect> bigRectList = new ArrayList<Rect>();
            for (int i = 0; i < rectList.size(); i++) {
                Rect rect = rectList.get(i);
                if (rect.width > 100 && rect.height > 100){
                    bigRectList.add(rect);
                }
            }

            System.out.println("RectSize= " + bigRectList.size());
            for (int i = 0; i < bigRectList.size(); i++) {

                /*
                 * 绘制一个简单的，粗的或实心的直角矩形。 函数cv :: rectangle绘制一个矩形轮廓或一个填充的矩形，其两个相对角为pt1和pt2。
                 * @param img图片。
                 * @param pt1矩形的顶点。
                 * @param pt2与pt1相反的矩形的顶点。
                 * @param color矩形的颜色或亮度（灰度图像）。
                 * @param thickness组成矩形的线的粗细。 负值（如#FILLED）表示该函数必须绘制一个填充的矩形。
                 * @param lineType线的类型。 请参阅https://blog.csdn.net/ren365880/article/details/103952856
                 * @param shift点坐标中的小数位数。
                 */
                Imgproc.rectangle(resizeImage, bigRectList.get(i).tl(), bigRectList.get(i).br(), circleColor, 2, Imgproc.LINE_AA, 0 );

            }


            //10 画圆
            for (int i = 0; i < circleList.size(); i++) {
                Circle circle = circleList.get(i);
                System.out.println("i:" + i + " " + circle.getCenter() + "radius=" + circle.getRadius());

                /*
                 * 画一个圆。 函数Imgproc.circle绘制具有给定中心和半径的简单或实心圆。
                 * @param img绘制圆的图像。
                 * @param center圆心。
                 * @param radius圆的半径。
                 * @param color圆形颜色。
                 * @param thickness圆轮廓的宽度（如果为正）。 负值（如#FILLED）表示要绘制一个实心圆。
                 * @param lineType圆边界的类型。 请参阅https://blog.csdn.net/ren365880/article/details/103952856
                 * @param shift中心坐标和半径值中的小数位数。
                 */
//                Imgproc.circle(resizeImage, circle.getCenter(), circle.getRadius(), circleColor, circleThick, Imgproc.LINE_AA, 0);
            }

            //8点和17点 ，11点为目标点
            circle(resizeImage, circleList.get(11).getCenter(), 30, new Scalar(70,240,60), 2);


            imshow("s", resizeImage);

            //按任何键，关闭图片窗口
            while (true) {
                if (waitKey(0) == 27) {
                    break;
                }
            }
        }

    }

}
