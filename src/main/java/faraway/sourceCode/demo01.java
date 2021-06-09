package faraway.sourceCode;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.FileNotFoundException;
import java.net.URL;

import static faraway.sourceCode.MyPrint.printnb;
import static org.opencv.highgui.HighGui.waitKey;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.cvtColor;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-26 15:42
 */

public class demo01 {
    public static void main(String[] args) throws FileNotFoundException {

        URL url = ClassLoader.getSystemResource("lib/opencv_java452.dll");
        System.load(url.getPath());

        String path = "D:\\plane.jpg";
        Mat image = imread(path,1);
        Mat newImage = new Mat();
        cvtColor(image,newImage,Imgproc.COLOR_RGB2GRAY);
        System.out.println(image.empty());
//        imshow("name",image);
//        imshow("new",newImage);
        waitKey();
        System.out.println("cc"+image);

        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
    }

    //j循环每次取出数组最小的数，放在第i的位置；理论的复杂度，应该是i*(j-1);
    //bubble sort
   static void arraySort01(int[] arr) {
       long start = System.currentTimeMillis();
       int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
       long end = System.currentTimeMillis();
       printnb("time:1 " + (end-start));


    }

    //1 i循环遍历数组，将下标传递给m;
    //2 j循环从i的下一个元素开始，找到数组中余下元素最小的下标；
    //3 如为最小下标，则交换最小下标与i的值；否则，i即为最小值；
    //select sort
    static void arraySort02(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[m]) {
                    m = j;
                }
            }
            if(m != i) {
                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;
            }
        }
        long end = System.currentTimeMillis();
        printnb("time: 2 " + (end-start));


    }

    //insert sort
    //每次把i元素与前一个元素对比，如果i元素小于前一个元素；则将0-i的元素排序；并把i插入到指定位置；
    static void arraySort03(int[] arr) {
        long start = System.currentTimeMillis();
        //1 i循环遍历数组
        for (int i = 1; i < arr.length; i++) {

            //2 将i元素赋值temp
            int temp = arr[i];

            //i-1赋值给j
            int j = i - 1;

            while(temp < arr[j]) {
                //对小于i的数组部分，进行排序
                arr[j+1] = arr[j];
                j--;
                if(j < 0){
                    break;
                }
            }
            //将元素i的值，插入到指定j+1位置；
            arr[j+1] = temp;
        }
        long end = System.currentTimeMillis();
        printnb("time:3=" + (end-start));

    }

    //
    private static void sort(int[] a, int left, int right, boolean leftmost) {

        long start = System.currentTimeMillis();

        int length = right - left + 1;

        // Use insertion sort on tiny arrays
        if (leftmost) {
            /*
             * Traditional (without sentinel) insertion sort,
             * optimized for server VM, is used in case of
             * the leftmost part.
             */
            for (int i = left, j = i; i < right; j = ++i) {
                int ai = a[i + 1];
                while (ai < a[j]) {
                    a[j + 1] = a[j];
                    if (j-- == left) {
                        break;
                    }
                }
                a[j + 1] = ai;
            }
        } else {
            /*
             * Skip the longest ascending sequence.
             */
            do {
                if (left >= right) {
                    return;
                }
            } while (a[++left] >= a[left - 1]);

            /*
             * Every element from adjoining part plays the role
             * of sentinel, therefore this allows us to avoid the
             * left range check on each iteration. Moreover, we use
             * the more optimized algorithm, so called pair insertion
             * sort, which is faster (in the context of Quicksort)
             * than traditional implementation of insertion sort.
             */
            for (int k = left; ++left <= right; k = ++left) {
                int a1 = a[k], a2 = a[left];

                if (a1 < a2) {
                    a2 = a1;
                    a1 = a[left];
                }
                while (a1 < a[--k]) {
                    a[k + 2] = a[k];
                }
                a[++k + 1] = a1;

                while (a2 < a[--k]) {
                    a[k + 1] = a[k];
                }
                a[k + 1] = a2;
            }
            int last = a[right];

            while (last < a[--right]) {
                a[right + 1] = a[right];
            }
            a[right + 1] = last;
        }

        long end = System.currentTimeMillis();
        printnb("time:4=" + (end-start));
        return;
    }

}
