package com.lsh.hotkey.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: JSON文件数据操作
 * @author: LuShao
 * @create: 2020-06-09 16:13
 **/
public class JsonUtil {

	/**
	 * 读取json文件 并转换成对象
	 *
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> jsonToObject(String filePath, Class<T> clazz) {
		String jsonStr = readJson(filePath);
		Object object = JSON.parse(jsonStr);
		List list = null;
		if (object instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject) object;
			T t = JSONObject.parseObject(jsonStr, clazz);
			list = new ArrayList();
			list.add(t);
		} else if (object instanceof JSONArray) {
			list = JSONObject.parseArray(jsonStr, clazz);
		}
		if (list == null) {
			list = new ArrayList();
		}
		return list;
	}

	/**
	 * 读取json文件
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 *
	 * @param filePath
	 * @return
	 */
	public static String readJson(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			//BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			fis.close();
			br.close();
			return sb.toString();
		} catch (Exception e) {
			//e.printStackTrace();
			return "";
		}
	}

	/**
	 * 讲对象转换成json格式字符串，并写入指定文件
	 * @param o
	 * @param root
	 * @param fileName
	 * @return
	 */
	public static boolean objectToJson(Object o, String root, String fileName) {
		String jsonStr = JSON.toJSON(o).toString();
		boolean b = false;
			//b = writeJsonToFile(new String(jsonStr.getBytes(),"utf-8"), root, fileName);
			b = writeJsonToFile(jsonStr, root, fileName);
		return b;
	}

	/**
	 * 将jsonstr写入到json文件
	 *
	 * @param jsonStr
	 * @param root
	 * @param file
	 * @return
	 */
	public static boolean writeJsonToFile(String jsonStr, String root, String fileName) {
		try {
			File rootf = new File(root);
			if (!rootf.exists()) {
				rootf.mkdirs();
			}
			OutputStream out=new FileOutputStream(root + fileName);
			//BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
			BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out));
			//FileWriter fw = new FileWriter(root + fileName);
			//PrintWriter pw = new PrintWriter(fw);
			// 格式化json
			//String json = new String(formatJson(jsonStr).getBytes(),"utf-8");
			String json = formatJson(jsonStr);
			rd.write(json);
			//rd.write(new String(json));
			rd.flush();
			out.close();
			rd.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 格式化JSON
	 *
	 * @author Anndy
	 */
	public static String formatJson(String jsonStr) {
		if (null == jsonStr || "".equals(jsonStr)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		char last = '\0';
		char current = '\0';
		int indent = 0;
		boolean isInQuotationMarks = false;
		for (int i = 0; i < jsonStr.length(); i++) {
			last = current;
			current = jsonStr.charAt(i);
			switch (current) {
				case '"':
					if (last != '\\') {
						isInQuotationMarks = !isInQuotationMarks;
					}
					sb.append(current);
					break;
				case '{':
				case '[':
					sb.append(current);
					if (!isInQuotationMarks) {
						sb.append('\n');
						indent++;
						addIndentBlank(sb, indent);
					}
					break;
				case '}':
				case ']':
					if (!isInQuotationMarks) {
						sb.append('\n');
						indent--;
						addIndentBlank(sb, indent);
					}
					sb.append(current);
					break;
				case ',':
					sb.append(current);
					if (last != '\\' && !isInQuotationMarks) {
						sb.append('\n');
						addIndentBlank(sb, indent);
					}
					break;
				default:
					sb.append(current);
			}
		}

		return sb.toString();
	}

	/**
	 * 添加space
	 */
	private static void addIndentBlank(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append('\t');
		}
	}

	/**
	 * 读取json文件内容
	 *
	 * @return
	 */
	public static String readJson_bak() {
		String content = "";
		try {
			File jsonFile = ResourceUtils.getFile("classpath:config.json");
			content = FileUtils.readFileToString(jsonFile, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * 读取json文件
	 *
	 * @return
	 */
	public static String readJson() {
		return new String(toData("config.json"), StandardCharsets.UTF_8);
	}

	/**
	 * 打jar包之后  使用该读取文件的方法
	 *
	 * @param filepath
	 * @return
	 */
	public static byte[] toData(String filepath) {
		byte[] bdata = new byte[0];
		ClassPathResource cpr = new ClassPathResource(filepath);
		try {
			bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bdata;
	}

	public static void main(String[] args) throws MalformedURLException {
	    /*List list = new ArrayList();
	    list.add(123);
	    list.add(12333);
	    list.add(12113);
	    //list.add(1);
		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println("=================");
		list.remove(0);
		for (Object o : list) {
			System.out.println(o);
		}*/
	}
}
