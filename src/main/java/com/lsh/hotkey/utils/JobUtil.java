package com.lsh.hotkey.utils;

import com.lsh.hotkey.entry.TaskEntry;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.List;
import java.util.Set;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Description:
 * @author: LuShao
 * @create: 2020-07-19 22:24
 **/
public class JobUtil {

	/**
	 * 根据jobName删除
	 *
	 * @param taskName
	 */
	public static void deleteJob(String taskName) {
		try {
			Contains.scheduler.deleteJob(new JobKey(taskName));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 是否存在jobkey
	 *
	 * @param jobKey
	 * @return
	 */
	public static boolean isExistJobKey(String jobKey) {
		Scheduler scheduler = Contains.scheduler;
		try {
			List<String> jobGroupNames = scheduler.getJobGroupNames();
			for (String jobGroupName : jobGroupNames) {
				Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName));
				for (JobKey key : jobKeys) {
					if (jobKey.equals(key.getName())) {
						return true;
					}
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 绑定并执行任务
	 *
	 * @param taskEntry
	 */
	public static void bingTask(TaskEntry taskEntry) {
		Integer execType = taskEntry.getExecType();
		String taskName = taskEntry.getTaskName();
		StringBuffer sb = new StringBuffer();
		Integer taskId = taskEntry.getTaskId();
		if (execType == 1) {
			sb.append("JOptionPane.showMessageDialog(Contains.mainF,\"" + taskEntry.getMessage() + "\");");
		}
		if (execType == 2) {
			String[] execs = taskEntry.getExecs();
			for (int j = 0; j < execs.length; j++) {
				sb.append("Contains.exeCMD(\"cmd /c start " + execs[j] + "\");");
			}
		}
		if (execType == 3) {
			String cmd = taskEntry.getCmd();
			sb.append("Contains.exeCMD(\""+cmd+"\");");
			//sb.append("JOptionPane.showMessageDialog(\"启动完成~\");");
		}
		try {
			Class clazz = ClazzUtil.testInvoke("CronJob" + taskId, sb.toString());
			// JobDetail  
			JobDetail jobDetail = newJob(clazz)
					.withIdentity(taskName)
					.build();
			// Trigger
			Trigger trigger = newTrigger()
					.withIdentity("trigger" + taskId)
					.withSchedule(cronSchedule(taskEntry.getCronExpre()))
					.forJob(taskName).build();
			// 绑定关系是1：N
			Contains.scheduler.scheduleJob(jobDetail, trigger);
			Contains.scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
