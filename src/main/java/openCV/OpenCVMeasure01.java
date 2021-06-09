package openCV;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.net.URL;
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
 * @date: 2021-06-07 11:04
 */

public class OpenCVMeasure01 {
    public static void main(String[] args) {

        String path = "D:\\testPic\\blank1.jpg";
        double proportion = 0.3;

        //1 连接openCV库
        URL url = ClassLoader.getSystemResource("lib/opencv_java452.dll");
        System.load(url.getPath());

        //2 读取图片
        Mat image = imread(path, 1);

        //3 图像尺寸缩小比例
        Mat sImage = new Mat();
        Imgproc.resize(image, sImage, new Size(image.cols() * proportion, image.rows() * proportion), 0, 0, Imgproc.INTER_AREA);

        //4 灰度处理
        Mat grayImage = new Mat();
        cvtColor(sImage, grayImage, Imgproc.COLOR_BGR2GRAY);

        //5 二值处理
        Mat bImage = new Mat(grayImage.height(), grayImage.width(), CvType.CV_8UC1);
        Imgproc.threshold(grayImage, bImage, 210, 250, Imgproc.THRESH_BINARY);
        BufferedImage bufferedImage = OpenCVUtils.toBufferedImage(bImage);
        String path1 = "D:\\javaTest\\bImage.jpg";
//        imshow("binaryImage", bImage);

        //6 图像膨胀-可选
        Mat dilateMat = new Mat();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3), new Point(-1, -1));
        Imgproc.dilate(bImage, dilateMat, element, new Point(-1, -1), 1);
//        imshow("dilateMat", dilateMat);


        //7 图像腐蚀-可选
        Mat erodeMat = new Mat();
        Imgproc.erode(dilateMat, erodeMat, element, new Point(-1, -1), 1);
//        imshow("erodeMat", erodeMat);

        //8 获取图像边缘-可选
        Mat cannyMat = new Mat();
        Imgproc.Canny(erodeMat, cannyMat, 3, 3, 3, true);


        //9 获取图像轮廓
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hImage = new Mat();
        Imgproc.findContours(cannyMat, contours, hImage, RETR_EXTERNAL,
                Imgproc.CHAIN_APPROX_SIMPLE, new Point(0, 0));

        //10 遍历图像轮廓，取顶点
        Mat tImage = new Mat(sImage.rows(), sImage.cols(), CvType.CV_8UC1, new Scalar(0));
        for (int i = 0; i < contours.size(); i++) {
            Imgproc.drawContours(tImage, contours, i, new Scalar(255), 2);
        }

        ArrayList<Point> arrayList = OpenCVUtils.findAllPoints(tImage, 250);
        Point plt = OpenCVUtils.findMinDistancePoint(arrayList, 0, 0);
        Point prt = OpenCVUtils.findMinDistancePoint(arrayList, sImage.cols(), 0);
        Point plb = OpenCVUtils.findMinDistancePoint(arrayList, 0, sImage.rows());
        Point prb = OpenCVUtils.findMinDistancePoint(arrayList, sImage.cols(), sImage.rows());

        ArrayList<Point> points = OpenCVUtils.findRangePoints(tImage, 250, 200, 200);
        Point p = OpenCVUtils.findMinDistancePoint(points, 0, 0);
        System.out.println("px =" + p.x + " py="+ p.y);
        System.out.println("pltx =" + plt.x + " plty="+ plt.y);

        System.out.println("x =" + (prt.x - plt.x) );
        System.out.println("height =" +(plb.y - plt.y)/((prt.x - plt.x)/125.5) );

        System.out.println("y =" + (plb.y - plt.y) );

        line(tImage, new Point(tImage.cols() / 2, tImage.rows() / 3 - 50), new Point(tImage.cols() / 2, tImage.rows() / 3 + 50), new Scalar(0, 255, 0), 2);

        circle(tImage, prb, 3, new Scalar(255), 2);
//        circle(tImage, pointList.get(0),3, new Scalar(0, 255, 0),2);
//        circle(tImage, pointList.get(570),3, new Scalar(100, 255, 0),2);

        Mat nImage = new Mat(sImage.rows(), sImage.cols(), CvType.CV_8UC3, new Scalar(0));

        line(nImage, plt, prt, new Scalar(0, 255, 0), 2);
        line(nImage, prt, prb, new Scalar(0, 255, 0), 2);
        line(nImage, prb, plb, new Scalar(0, 255, 0), 2);
        line(nImage, plb, plt, new Scalar(0, 255, 0), 2);

        imshow("nImage", nImage);


        //按任何键，关闭图片窗口
        while (true) {
            if (waitKey(0) == 27) {
                break;
            }
        }

    }
}
