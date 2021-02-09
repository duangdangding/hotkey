package com.lsh.hotkey.entry;

import com.lsh.hotkey.utils.Contains;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 文件信息对象
 * @author: LuShao
 * @create: 2020-11-25 15:08
 **/
public class FilePojo implements Serializable {
	private String filePath;
	private String fileName;
	private String fileType;
	private long fileSize;
	private String createTime;
	public FilePojo() {}
	public FilePojo(String filePath,String fileName,String fileType,long fileSize,String createTime) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.createTime = createTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

}
