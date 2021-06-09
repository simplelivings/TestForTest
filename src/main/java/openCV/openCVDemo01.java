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
import static org.opencv.imgproc.Imgproc.RETR_LIST;
import static org.opencv.imgproc.Imgproc.cvtColor;


/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-05-20 14:45
 */

public class openCVDemo01 {
    public static void main(String[] args) {

        //1 连接openCV库
        URL url = ClassLoader.getSystemResource("lib/opencv_java452.dll");
        System.load(url.getPath());


        //2 读取图片
        String path = "D:\\nut2.jpg";
        Mat image = imread(path, 1);

        Mat sImage = new Mat();
        Imgproc.resize(image, sImage, new Size(image.cols() / 2, image.rows() / 2), 0, 0, Imgproc.INTER_AREA);


        //中值模糊(像素两极化，去除杂点，容易制造出新的大面积杂点)，选做
//        Mat medianMat = new Mat();
//        medianBlur(sImage, medianMat, 3);
//        imshow("medianBlur", medianMat);
        //高斯模糊
//        Mat gaussianMat = new Mat();
//        GaussianBlur(image,gaussianMat, new Size(3,3),4);


        //3 灰度处理
        Mat grayImage = new Mat();
        cvtColor(sImage, grayImage, Imgproc.COLOR_BGR2GRAY);

        //显示图片
//        imshow("old",grayImage);
//        waitKey(1);


        //获取像素并对其处理
        Mat sMat= new Mat(sImage.height(), sImage.width(), CvType.CV_8UC1 , new Scalar(255, 255));
        int height = sMat.rows();
        int width = sMat.cols();
        int channel =  sMat.channels();
        for (int i = 0; i < height; i++) {
            for (int i1 = 0; i1 < width; i1++) {

                double t = sMat.get(i,i1)[0] - 255;
                sMat.put(i,i1,t);
            }
        }
        int k = 5;
        k -= 2;
        System.out.println("k::" + k);
        System.out.println("sMat::" + sMat.get(100,100)[0]);
//        System.out.println("dump:: "+ sMat.dump());
        System.out.println("channel:: "+ channel);
        imshow("tMat", sMat);

        //4 二值处理
        Mat bImage = new Mat(grayImage.height(), grayImage.width(), CvType.CV_8UC1);
        Imgproc.threshold(grayImage, bImage, 150, 250, Imgproc.THRESH_BINARY);
        BufferedImage bufferedImage = OpenCVUtils.toBufferedImage(bImage);
        String path1 = "D:\\javaTest\\bImage.jpg";
        imshow("binaryImage", bImage);

        //霍夫圆检测
//        Mat circles  =  new Mat();
//        Imgproc.HoughCircles(grayImage, circles, Imgproc.HOUGH_GRADIENT, 1, 300, 400, 100, 0, 100);
//        System.out.println("huofu: " + circles.cols());
//        for (int i = 0; i < circles.cols(); i++) {
//            double[] vCircle = circles.get(0, i);
//
//            Point center = new Point(vCircle[0], vCircle[1]);
//            int radius = (int) Math.round(vCircle[2]);
//
//            // circle center
//            Imgproc.circle(sImage, center, 3, new Scalar(0, 255, 0), -1, 8, 0);
//            // circle outline
//            Imgproc.circle(sImage, center, radius, new Scalar(0, 255, 255), 3, 8, 0);
//
//        }


//        // 图像膨胀-可选
        Mat dilateMat = new Mat();
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3), new Point(-1, -1));
        Imgproc.dilate(bImage, dilateMat, element, new Point(-1, -1), 1);
        imshow("dilateMat", dilateMat);
//
////
//        // 图像腐蚀-可选
        Mat erodeMat = new Mat();
        Imgproc.erode(dilateMat, erodeMat, element, new Point(-1, -1), 1);
        imshow("erodeMat", erodeMat);

        // 获取图像边缘-可选
        Mat cannyMat = new Mat();
        Imgproc.Canny(erodeMat, cannyMat, 3, 3, 3, true);
////        Imgcodecs.imwrite("cannyImage", cannyMat);
//        System.out.println("size:::" + cannyMat.cols());
//
//        imshow("cannyImage" , cannyMat);
//        Mat hline = getStructuringElement(MORPH_RECT,new Size(), new Point(-1, -1));

        //5 获取图像轮廓
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hImage = new Mat();
        Imgproc.findContours(cannyMat, contours, hImage, RETR_LIST,
                Imgproc.CHAIN_APPROX_SIMPLE, new Point(0, 0));
        System.out.println("ListContoursSize: " + contours.size());
        for (int i = 0; i < contours.size(); i++) {
            Imgproc.drawContours(sImage, contours, i, new Scalar(150, 5, 50, 50), 2);
        }
        for (int i = 0; i < cannyMat.cols(); i++) {
        }


        System.out.println("contoursSize::" + contours.size());
//        imshow("hImage", hImage);
//        BufferedImage bufferedImage1 = ImageUtils.toBufferedImage(hImage);
//        ImageUtils.saveJpgImage(bufferedImage1, path1);

//        approxPolyDP();


        //8 找到圆的轮廓
        Scalar color2 = new Scalar(0, 0, 220);
        //nut 1
        List<Circle> circles = OpenCVUtils.findCircles(contours, 5, 150);
        //nut01
//        List<Circle> circles = ImageUtils.findCenters(contours, 25, 30);

        //画圆
        for (int i = 0; i < circles.size(); i++) {
//            System.out.println(circles.get(i).getRadius());
            Circle circle = circles.get(i);
            Imgproc.circle(sImage, circle.getCenter(), circle.getRadius(), color2, 2, Imgproc.LINE_AA, 0);
        }

        //9 对圆心位置进行判断
//        for (int i = 0; i < circles.size(); i++) {
//            Point p = circles.get(i).getCenter();
//            double key = 0.1 ;
//            double minX = p.x - p.x * key;
//            double maxX = p.x + p.x * key;
//            double minY = p.y - p.y * key;
//            double maxY = p.y + p.y * key;
//
//            if ()
//        }


        imshow("s", sImage);

        //按任何键，关闭图片窗口
        while (true) {
            if (waitKey(0) == 27) {
                break;
            }
        }

    }
}
