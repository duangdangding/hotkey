package com.lsh.hotkey.utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * @Description: 过滤excel文件类型选择器
 * @author: LuShao
 * @create: 2020-07-14 14:11
 **/
public class ExcelFileFilter extends FileFilter {
	/**
	 * 仅显示目录和xls、xlsx文件  
	 * @param f
	 * @return
	 */
	@Override
	public boolean accept(File f) {
		String name = f.getName().toLowerCase();
		return f.isDirectory() || name.endsWith(".xls") || name.endsWith(".xlsx");  
	}

	@Override
	public String getDescription() {
		return "*.xls;*.xlsx";
	}
}
