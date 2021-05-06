package com.kixs.opencv;

import org.junit.jupiter.api.Test;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.util.concurrent.locks.ReentrantLock;


@SpringBootTest
public class OpencvTestApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) throws Exception {
        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("lib/opencv/opencv_java451.dll");
        System.load(url.getPath());
        // 读取图像
        Mat image = Imgcodecs.imread("E:\\opencv-data\\2000.jpg");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
        HighGui.imshow("Original Image", image);

        // 创建输出单通道图像
        Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);
        // 进行图像色彩空间转换
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_RGB2GRAY);

        HighGui.imshow("Processed Image", grayImage);
        Imgcodecs.imwrite("E:\\opencv-data\\2000-1.jpg", grayImage);
        HighGui.waitKey();
    }

    @Test
    public void testOpencv() throws Exception {

        // 解决awt报错问题
        System.setProperty("java.awt.headless", "false");
        System.out.println(System.getProperty("java.library.path"));
        // 加载动态库
        URL url = ClassLoader.getSystemResource("lib/opencv/opencv_java451.dll");
        System.load(url.getPath());
        // 读取图像
        Mat image = Imgcodecs.imread("E:\\opencv-data\\2000.jpg");
        if (image.empty()) {
            throw new Exception("image is empty");
        }
        HighGui.imshow("Original Image", image);

        // 创建输出单通道图像
        Mat grayImage = new Mat(image.rows(), image.cols(), CvType.CV_8SC1);
        // 进行图像色彩空间转换
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_RGB2GRAY);

        HighGui.imshow("Processed Image", grayImage);
        Imgcodecs.imwrite("E:\\opencv-data\\2000-1.jpg", grayImage);
        HighGui.waitKey();
    }

}
