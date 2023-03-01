package com.lsh.hotkey.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 定时任务信息
 * @author: LuShao
 * @create: 2020-07-15 14:38
 **/
@Data
public class TaskEntry implements Serializable {
	private Integer taskId;
	private String cronExpre; // cron表达式
	private Integer execType;// 执行类型 1 文本消息 2 启动程序 3 执行CMD命令
	private String message;// 提示消息
	private String[] execs;// 程序列表
	private String cmd; // CMD命令
	// private String comment;// 注释
	private Integer state; // 0禁用 1启用
	private String taskName;// 名字
}
