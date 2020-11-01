package com.lsh.hotkey.entry;

/**
 * @Description: 定时任务信息
 * @author: LuShao
 * @create: 2020-07-15 14:38
 **/
public class TaskEntry {
	private Integer taskId;
	private String cronExpre; // cron表达式
	private Integer execType;// 执行类型 1 文本消息 2 启动程序 3 执行CMD命令
	private String message;// 提示消息
	private String[] execs;// 程序列表
	private String cmd; // CMD命令
	private String comment;// 注释
	private String taskName;// 名字

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCronExpre() {
		return cronExpre;
	}

	public void setCronExpre(String cronExpre) {
		this.cronExpre = cronExpre;
	}

	public Integer getExecType() {
		return execType;
	}

	public void setExecType(Integer execType) {
		this.execType = execType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getExecs() {
		return execs;
	}

	public void setExecs(String[] execs) {
		this.execs = execs;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
