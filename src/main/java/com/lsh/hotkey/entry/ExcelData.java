package com.lsh.hotkey.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: excel信息
 * @author: LuShao
 * @create: 2020-07-14 17:27
 **/
public class ExcelData implements Serializable {
	
	private String sheetName; // 工作表的名字
	private String[] headers; // 头部
	private List<?> list = new ArrayList<>(); // 数据
	private int startRow = 0; //从第几行开始
	private int startCell = 0; // 从第几列开始

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getStartCell() {
		return startCell;
	}

	public void setStartCell(int startCell) {
		this.startCell = startCell;
	}
}
