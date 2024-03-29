package com.lsh.hotkey.utils;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.json.JSONUtil;
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
	 * 读取json文件转成JSONObject
	 * @author lushao
	 * 2023/3/1 13:32
	 * @param filePath
	 * @return cn.hutool.json.JSONObject
	 */
	public static cn.hutool.json.JSONObject readJsonFileToObject(String filePath) {
		try {
			return JSONUtil.readJSONObject(new File(filePath),StandardCharsets.UTF_8);
		} catch (IORuntimeException e) {
//			throw new RuntimeException(e);
			return new cn.hutool.json.JSONObject();
		}
	}

	/**
	 * 读取json文件转成JSONArray
	 * @author lushao
	 * 2023/3/1 13:44
	 * @param filePath
	 * @return cn.hutool.json.JSONArray
	 */
	public static cn.hutool.json.JSONArray readJsonFileToJsonArray(String filePath) {
		try {
			return JSONUtil.readJSONArray(new File(filePath), StandardCharsets.UTF_8);
		} catch (IORuntimeException e) {
//			throw new RuntimeException(e);
			return new cn.hutool.json.JSONArray();
		}
	}

	/**
	 * 将对象转换成json格式字符串，并写入指定文件
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
	 * @return
	 */
	public static boolean writeJsonToFile(String jsonStr, String root, String fileName) {
		try {
			File rootf = new File(root);
			if (!rootf.exists()) {
				rootf.mkdirs();
			}
			OutputStream out=new FileOutputStream(root + fileName);
			BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out));
			// 格式化json
			//String json = formatJson(jsonStr);
			rd.write(jsonStr);
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
	 * 添加space
	 */
	private static void addIndentBlank(StringBuilder sb, int indent) {
		for (int i = 0; i < indent; i++) {
			sb.append('\t');
		}
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

	/**
	 * json 转 List<T>
	 */
	public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
		@SuppressWarnings("unchecked")
		List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
		return ts;
	}

}
