package com.lsh.hotkey.utils;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 视频工具包
 */
public class VideoUtil {
    public static long videoLen = 0L;
    public static int frameLen = 0;
    public static double unitFrame = 0;
    public static int height = 0;
    public static int width = 0;
    /*static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }*/
    /**
     * 获取视频时长 单位/秒
     * 设置视频帧率（帧率越低，视频会出现断层，越高让人感觉越连续），
     * 视频帧率（Frame rate）是用于测量显示帧数的量度。所谓的测量单位为每秒显示帧数(Frames per Second，简：FPS）或“赫兹”（Hz）。
     * @param video
     * @return
     */
    public static void getVideoDuration(File video) {
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(video);
        try {
            ff.start();
            videoLen = ff.getLengthInTime() / (1000 * 1000);
            frameLen = ff.getLengthInFrames();
            unitFrame = ff.getFrameRate();
            System.out.println("时间s：" + videoLen);
            System.out.println("帧数：" + frameLen);
            System.out.println("秒/帧：" + unitFrame);
            height = ff.getImageHeight();
            width = ff.getImageWidth();
            System.out.println("视频高和宽：" + height + "~" + width);
            ff.stop();
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 截取视频指定帧生成gif
     *
     * @param videofile  视频文件
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param frameRate  帧频率（默认：3）
     * @param margin     每截取一次跳过多少帧（默认：3）
     * @param outputPath  需要保存的目录
     * @throws java.io.IOException 截取的长度超过视频长度
     */
//    public static void buildGif(String videofile, String startTime, String endTime, Integer frameRate, 
//                                Integer margin,String outputPath) throws IOException {
    public static void buildGif(String videofile, String startTime, String endTime,
                                Integer margin,String outputPath ,String zoom) throws IOException {
        int startFrame = 0;
        int endFrame = frameLen;
        if (startTime.length() > 0) {
            startFrame = (int) (Contains.timeToSecond(startTime) * unitFrame);
        }
        if (endTime.length() > 0) {
            endFrame = (int) (Contains.timeToSecond(endTime) * unitFrame);
        }
        /*if (margin == null) {
            margin = 3;
        }*/
        /*if (frameRate == null) {
            frameRate = 3;
        }*/

        String fileName = videofile.substring(videofile.lastIndexOf(File.separator) + 1);
        FileOutputStream targetFile = new FileOutputStream(outputPath + File.separator + fileName.substring(0, fileName.lastIndexOf(".")) + ".gif");
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        if (zoom.length() > 0) {
            float z = Float.valueOf(zoom);
            int w = (int) (width * z);
            int h = (int) (height * z);
            ff.setImageHeight(h);
            ff.setImageWidth(w);
            System.out.println("视频修改之后高和宽:" + ff.getImageHeight() + "~" + ff.getImageWidth());
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        ff.start();
        try {
            System.out.println("开始帧：" + startFrame + "结束帧：" + endFrame);
            int frameCount = endFrame - startFrame;
            if (frameCount <= 0) {
                throw new RuntimeException("所截取的视频太短了！");
            }
            ff.setFrameNumber(startFrame);
            AnimatedGifEncoder en = new AnimatedGifEncoder();
//            en.setFrameRate(frameRate);
            en.setFrameRate(3);
            en.start(targetFile);
            for (int i = 0; i < frameCount; i++) {
                en.addFrame(converter.convert(ff.grabImage()));
                ff.setFrameNumber(ff.getFrameNumber() + margin);
            }
            en.finish();
        } finally {
            ff.stop();
            ff.close();
        }
    }

    public static void main(String[] args) {

        String filename = "E:\\littleVideo\\居家小技巧.mp4";
        String substring = filename.substring(filename.lastIndexOf(File.separator));
//        VideoCapture open = new VideoCapture(1);
//        open.open(filename);
        System.out.println(substring);
        getVideoDuration(new File(filename));
        System.out.println(videoLen + "秒");
        System.out.println(frameLen + "帧");
        String out = "C:\\Users\\Administrator\\Desktop\\";
       /* try {
            buildGif(filename,0, 0,null,null,out);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
