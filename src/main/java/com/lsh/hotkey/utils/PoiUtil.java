package com.lsh.hotkey.utils;

import com.lsh.hotkey.entry.ExcelData;
import com.lsh.hotkey.entry.Hotkey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 表格文档工具
 * @author: LuShao
 * @create: 2020-07-14 12:25
 **/
public class PoiUtil {

	/**
	 * 创建工作簿
	 * @param path
	 */
	public static void createExccel(String path, ExcelData data) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(data.getSheetName());

		// 创建单元格样式
		CellStyle style= workbook.createCellStyle();
// 设置为文本格式，防止身份证号变成科学计数法
		DataFormat format = workbook.createDataFormat();
		style.setDataFormat(format.getFormat("@"));
//对单独某一列进行样式赋值，第一个参数为列数，第二个参数为样式
		sheet.setDefaultColumnStyle(0, style);
		sheet.setDefaultColumnStyle(4, style);
		
		List<?> list = data.getList();
		String[] headers = data.getHeaders();
		// 设置头部
		createHeader(sheet,headers);
		// 设置内容
		setContent(sheet,list);
		//	写入文件
		writeWorkBook(workbook,path);
	}

	/**
	 * 写入到文件
	 * @param workbook
	 * @param path
	 */
	private static void writeWorkBook(XSSFWorkbook workbook,String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		try{
			OutputStream os=new FileOutputStream(file+File.separator+Contains.BACKFILEN);
			workbook.write(os);
			os.flush();
			os.close();
			workbook.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置表格内容
	 * @param sheet
	 * @param list
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private static void setContent(XSSFSheet sheet,List<?> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		int size = list.size();
		if (size > 0) {
			Class<?> clazz = list.get(0).getClass();
			Field[] fields = clazz.getDeclaredFields();
			Method method = null;
			Object o;
			Cell cell;
			for (int i = 0; i < size; i++) {
				XSSFRow row = sheet.createRow(i + 1);
				for (int j = 0; j < fields.length; j++) {
					Field field = fields[j];
					//如果字段是私有的,那么必须要对这个字段设置
					field.setAccessible(true);
					method = clazz.getDeclaredMethod(ClazzUtil.getMethodName(field.getName()));
					method.setAccessible(true);
					o = method.invoke(list.get(i));
					cell = row.createCell(j, CellType.STRING);
					if (o == null) {
						cell.setCellValue("");
					} else {
						// 是数组对象
						boolean b = Contains.isArray(o);
						if (b) {
							//对象转数组
							int length = Array.getLength(o);
							StringBuffer sb = new StringBuffer();
							for (int k = 0; k < length; k++) {
								Object o1 = Array.get(o, k);
								sb.append(o1.toString()).append("，");
							}
							/*try {
								o = new String(sb.toString().getBytes(),"utf-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}*/
							o = sb.toString();
							//System.out.println(i+"."+j+"-->"+o);
						}
						cell.setCellValue(o.toString());
					}
				}
			}
		}
	}

	/**
	 * 创建头部
	 * @param sheet
	 * @param headers
	 */
	private static void createHeader(XSSFSheet sheet,String[] headers) {
		XSSFRow firstRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			XSSFCell cell = firstRow.createCell(i,CellType.STRING);
			cell.setCellValue(headers[i]);
		}
	}

	/**
	 * 使用反射机制解析excel
	 * @param path
	 * @return
	 */
	public static <T> List<T> parseExcel(String path,Class<T> cls,int id) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		InputStream input = new FileInputStream(new File(path));
		String suffix = path.substring(path.lastIndexOf("."), path.length()).toUpperCase();
		Workbook workbook = null;
		Sheet sheet = null;
		// excel 2003
		if (".XLS".equals(suffix)) {
			POIFSFileSystem fileSystem = new POIFSFileSystem(input);
			//工作簿
			workbook = new HSSFWorkbook(fileSystem);
			//获取第一个工作表 sheet
			sheet = workbook.getSheetAt(0);
		}
		// excel 2007
		if (".XLSX".equals(suffix)) {
			workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheetAt(0);
		}
		return readSheet(sheet,cls,id);
	}

	/**
	 *
	 * @param sheet
	 * @param cls
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private static <T> List<T> readSheet(Sheet sheet,Class<T> cls,int id) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		//	总行数
		int rows = sheet.getPhysicalNumberOfRows();
		// 总列数
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		List<T> list = new ArrayList<>();
		// 获取所有字段,public和protected和private,但是不包括父类字段
		Field[] fields = cls.getDeclaredFields();
		// 读取行
		for (int i = 0; i < rows-1; i++) {
			Row row = sheet.getRow(i+1);
			//创建对象
			T t = cls.newInstance();
			// 获取列
			for (int j = 0; j < fields.length; j++) {
				Field field = fields[j];
				field.setAccessible(true);
				// 都转成String类型
				String value = row.getCell(j).getStringCellValue();
				String fType = field.getType().toString();
				Method method = null;
				String fieldName = field.getName();
				switch (fType) {
					case "class java.lang.String" :
						method = cls.getMethod(ClazzUtil.setMethodName(fieldName),String.class);
						method.invoke(t,value);
						break;
					case "class java.lang.Integer" :
						method = cls.getMethod(ClazzUtil.setMethodName(fieldName),Integer.class);
						Integer v = Integer.valueOf(value);
						if (fieldName.toUpperCase().contains("ID")) {
							v = id+j;
						}
						method.invoke(t,v);
						break;
					case "class [Ljava.lang.String;" :
						method = cls.getMethod(ClazzUtil.setMethodName(fieldName),String[].class);
						//System.out.println(method);
						String[] ss;
						if (value.contains("，")) {
							ss = value.split("，");
							
						} else {
							ss = new String[1];
							ss[0] = value;
						}
						//这里 public Object invoke(Object obj, Object... args) 只有两个参数
						// 第二个参数如果是数组的话 要把数组转换成Object
						// 如果数组只有一个值也可以ss[1]
						method.invoke(t, (Object)ss);
						break;
					//case "class java.util.Date" :
					//	cls.getMethod(ClazzUtil.setMethodName(field.getName()),);
					//	method.invoke(t,value);
					//	break;
					default:
						break;
				}
			}
			list.add(t);
		}
		return list;
	}


	private static <T> void getCellValue(Row row,int i,Class<T> cls) {
		Cell cell = row.getCell(i);
	}

	/**
	 * 解析execl
	 * @param path
	 * @return
	 */
	public static void parseExcel_714(String path) throws IOException {
		InputStream input = new FileInputStream(new File(path));
		String suffix = path.substring(path.lastIndexOf("."), path.length()).toUpperCase();
		Workbook workbook = null;
		Sheet sheet = null;
		// excel 2003
		if (".xls".equals(suffix)) {
			POIFSFileSystem fileSystem = new POIFSFileSystem(input);
			//工作簿
			workbook = new HSSFWorkbook(fileSystem);
			//获取第一个工作表 sheet
			sheet = workbook.getSheetAt(0);
		}
		// excel 2007
		if (".xlsx".equals(suffix)) {
			workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheetAt(0);
		}
		//	总行数
		int rows = sheet.getPhysicalNumberOfRows();
		// 总列数
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int i = 1; i <= rows; i++) {
			Row row = sheet.getRow(i);
			Hotkey hotkey = new Hotkey();
			for (int j = 0; j < cells; j++) {
				Cell cell = row.getCell(j);
				getCellValue_714(row,j,hotkey);
			}
			Contains.HOTKEYS.add(hotkey);
		}
	}

	/**
	 * 得到表格内容
	 * @param row
	 * @param i
	 * @param hotkey
	 */
	private static void getCellValue_714(Row row,int i,Hotkey hotkey) {
		Cell cell = row.getCell(i);
		int cellType = cell.getCellType();
		switch (i) {
			case 0: //ID
				hotkey.setKId(Integer.valueOf(cell.getStringCellValue()));
				break;
			case 1: //热键
				hotkey.setHotkey(cell.getStringCellValue());
				break;
			case 2: // 内容
				hotkey.setKaction(cell.getStringCellValue());
				break;
			case 3: // 注释
				hotkey.setExplain(cell.getStringCellValue());
				break;
			case 4: // 是否加密
				//hotkey.setEncrypt(Integer.valueOf(cell.getStringCellValue()));
				hotkey.setEncrypt(cell.getStringCellValue());
				break;
		}
	}

	public static void main(String[] args) throws ParseException {
		//1606502693114
		//2020-11-28 02:44:53
		long l = System.currentTimeMillis();
		System.out.println(l);
		Date date = new Date(1606502693000L);
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(date);
		System.out.println(format);
		Date parse = sdf.parse("2020-11-28 02:44:53");
		long time = parse.getTime();
		System.out.println(time);
	}
}
