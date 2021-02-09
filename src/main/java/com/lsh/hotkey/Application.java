package com.lsh.hotkey;

import com.formdev.flatlaf.FlatLightLaf;
import com.lsh.hotkey.frame.IndexFrame;
import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.JsonUtil;
import com.lsh.hotkey.utils.SwingUtil;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Properties;

/**
 * @Description:
 * @author: LuShao
 * @create: 2020-06-09 23:05
 **/
public class Application {
	
	public static void main(String[] args) {
		// 读取属性文件
		try {
			//InputStream in = Application.class.getResourceAsStream("application.properties");
			//String path1 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
			//String path2 = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
			//org.springframework.util.ClassUtils
			//URL resource = Application.class.getResource("/");
			//String path = resource.getFile()+"application.properties";
			byte[] bytes = JsonUtil.toData("application.properties");
			//将字节数组转换成流
			InputStream in = new BufferedInputStream(new ByteArrayInputStream(bytes));
			Contains.props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//初始化任务
		StdSchedulerFactory sf =new StdSchedulerFactory();
		Properties propsSchedu = new Properties();
		propsSchedu.put("org.quartz.scheduler.instanceName","schedulerZName");
		propsSchedu.put("org.quartz.threadPool.threadCount","10");
		try {
			sf.initialize(propsSchedu);
			Contains.scheduler = sf.getScheduler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 读取并执行定时任务
		try {
			SwingUtil.readTask();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		//去读配置
		SwingUtil.readConfig();
		// 注册热键
		SwingUtil.registerHotKey();
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		IndexFrame indexFrame = new IndexFrame();
		Contains.mainF = indexFrame;
		indexFrame.open();
		// JFrame全局热键ESC关闭当前打开的窗口
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent event) {
				if (((KeyEvent) event).getID() == KeyEvent.KEY_PRESSED) {
//放入自己的键盘监听事件
//((KeyEvent) event).getKeyCode();// 获取按键的code
//((KeyEvent) event).getKeyChar();// 获取按键的字符
					if (((KeyEvent) event).getKeyCode() == KeyEvent.VK_ESCAPE) {
						SwingUtil.closeWindow(Contains.window);
					}
				}
			}
		}, AWTEvent.KEY_EVENT_MASK);
	}

}
