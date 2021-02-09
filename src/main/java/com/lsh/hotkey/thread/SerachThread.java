package com.lsh.hotkey.thread;

import com.lsh.hotkey.entry.FilePojo;
import com.lsh.hotkey.utils.Contains;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Author:LuShao
 * @Description: 使用线程搜索
 * @Date:Created in 12:10 2021/1/7
 * @Modified By:
 */
public class SerachThread extends Thread {
    private File root;
    private CountDownLatch latch;
    public SerachThread(File root,CountDownLatch latch) {
        this.root = root;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            getFileMsg(root);
            latch.countDown();//当前线程调用此方法，则计数减一
        }catch (Exception e) {
            e.printStackTrace();
        }
        // super.run();
    }
    /**
     * 递归遍历文件
     * @param file
     */
    private void getFileMsg(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    if (file1.isFile()) {
                        addFileMsg(file1);
                    } else {
                        getFileMsg(file1);
                    }
                }
            }
        } else {
            addFileMsg(file);
        }
    }
    /**
     * 组合文件信息
     * @param file
     */
    private void addFileMsg(File file) {
        String name = file.getName();
        String type = "";
        try {
            type = name.substring(name.lastIndexOf(".") + 1);
        } catch (StringIndexOutOfBoundsException e) {
            type = "N";
        }
        String format = Contains.NORMOLYMD.format(new Date(file.lastModified()));
        FilePojo pojo = new FilePojo(file.getAbsolutePath(),name,type,file.length(),format);
        Contains.FILES.add(pojo);
    }
}
