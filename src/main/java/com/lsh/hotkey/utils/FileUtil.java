package com.lsh.hotkey.utils;

import java.io.*;
import java.util.Properties;
import java.util.Timer;

/**
 * @Description:
 * @author: LuShao
 * @create: 2020-11-26 13:54
 **/
public class FileUtil {

	/**
	 * 读取properties文件
	 * @param path
	 * @return
	 */
	public static Properties readProp(String path) {
		Properties prop = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			prop.load(in);
			in.close();
		} catch (IOException e) {
			return null;
		}
		return prop;
	}

	/**
	 * 写入properties文件
	 * @param path
	 * @return
	 */
	public static Properties whiteProp(String path, Properties prop) {
		try {
			FileOutputStream out = new FileOutputStream(path);
			prop.store(out,"");
			out.close();
		} catch (IOException e) {
			return null;
		}
		return prop;
	}

	/*public static void main(String[] args) {
		File file = new File("D:\\test\\新建文件夹\\图片无损放大软件Topaz A.I. Gigapixel 4.0.2 Win 64.rar");
		System.out.println("修改之前的时间："+file.lastModified());

		setFileTime(file,System.currentTimeMillis());
		System.out.println("修改之后的时间："+file.lastModified());

	}*/
}
