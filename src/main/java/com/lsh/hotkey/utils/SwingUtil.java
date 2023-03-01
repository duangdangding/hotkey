package com.lsh.hotkey.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lsh.hotkey.entry.Hotkey;
import com.lsh.hotkey.entry.TaskEntry;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import org.quartz.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 创建CronTrigger
 * CronTrigger实例可以通过TriggerBuilder（配置主要属性）和CronScheduleBuilder（配置CronTrigger专有的属性）配置。
 * 为了以DSL风格使用这些builder，需要静态导入：下面这3个
 */

/**
 * @Description:
 * @author: LuShao
 * @create: 2020-07-15 14:16
 **/
public class SwingUtil {

	/**
	 * 设置剪切板内容 （后期能否做到 layui弹窗样式）
	 * @param data
	 */
	public static void setClipboard(String data) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(new StringSelection(data), null);
	}

	/**
	 * 选择jCheckBox
	 * @param str
	 */
	public static void selectBox(Container ct,String str) {
		int cron = Integer.parseInt(str);
		List<JCheckBox> allJCheckBox = SwingUtil.getAllJCheckBox(ct, null);
		for (JCheckBox jCheckBox : allJCheckBox) {
			int num = Integer.parseInt(jCheckBox.getText());
			if (num == cron) {
				jCheckBox.setSelected(true);
				break;
			}
		}
	}

	/**
	 * 获取所有选中的checkbox的值
	 * @param ct
	 * @return
	 */
	public static String getSelectBox(Container ct) {
		List<JCheckBox> allJCheckBox = getAllJCheckBox(ct, null);
		StringBuffer sb = new StringBuffer();
		for (JCheckBox jCheckBox : allJCheckBox) {
			if (jCheckBox.isSelected()) {
				String text = jCheckBox.getText();
				sb.append(text).append(",");
			}
		}
		int length = sb.length();
		return sb.substring(0,length-1).toString();
	}

	/**
	 * 获取组件中所有的JCheckBox
	 * @param ct
	 * @param list
	 * @return
	 */
	public static List<JCheckBox> getAllJCheckBox(Container ct, List<JCheckBox> list){
		if(list==null){
			list=new ArrayList<JCheckBox>();
		}
		int count=ct.getComponentCount();
		for(int i=0;i<count;i++){
			Component c=ct.getComponent(i);
			if(c instanceof JCheckBox){
				list.add((JCheckBox)c);
			}
			else if(c instanceof Container){
				getAllJCheckBox((Container)c,list);
			}
		}
		return list;
	}

	/**
	 * 初始化自定义table
	 */
	public static void initTable(JTable jTable,String[] headers,Object[][] os) {
		jTable.setModel(new DefaultTableModel(os,headers));
		//jTable.getColumnModel().getColumn(0);
	}

	/**
	 * 情况Jtable内容，使用反射设置表格内容
	 * @param jTable
	 * @param data
	 */
	public static void setValueTable(JTable jTable,List<?> data,String[] headers) {
		//清空内容
		//((DefaultTableModel)jTable.getModel()).getDataVector().clear();
		DefaultTableModel model = new DefaultTableModel(null,headers);
		if (CollUtil.isNotEmpty(data)){
			int size = data.size();
			try {
				Object o3 = data.get(0);
				if (o3 != null) {
					Class<?> claZZ = o3.getClass();
					Field[] fields = claZZ.getDeclaredFields();
					int columns = fields.length;

					model.setRowCount(size);
					model.setColumnCount(columns);
					Method method = null;
					Object o;
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < columns; j++) {
							Field field = fields[j];
							field.setAccessible(true);
							method = claZZ.getDeclaredMethod(ClazzUtil.getMethodName(field.getName()));
							method.setAccessible(true);
							Object o2 = data.get(i);
							if (o2 != null) {
								o = method.invoke(o2);
								// 是数组对象
								if (Contains.isArray(o)) {
									//对象转数组
									int length = Array.getLength(o);
									StringBuffer sb = new StringBuffer();
									for (int k = 0; k < length; k++) {
										Object o1 = Array.get(o, k);
										sb.append(o1.toString());
									}
									o = sb.toString();
								}
								model.setValueAt(o,i,j);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			model.setRowCount(0);
		}
		jTable.setModel(model);
	}

	// 初始化表格数据
	public static void tableCenter(JTable table, String[] headers, Object[][] os) {
		//public static void tableCenter(JTable table) {
		// 设置table内容居中
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, tcr);
		// 设置table Header居中
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		JTableHeader head = table.getTableHeader(); // 创建表格标题对象
		head.setFont(Contains.F_Y_0_16);// 设置表头字体
		table.setFont(Contains.F_Y_0_14);// 设置表格字体
		//多选
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		SwingUtil.initTable(table,headers,os);

		//table.setAutoscrolls(false);
		//table.setRowHeight(25);
	}

	/**
	 * 反射初始化table数据
	 * @param data
	 * @return
	 */
	public static Object[][] getTableData(List<?> data) {
		if (data != null && data.size() > 0) {
			try {
				Class<?> clazz = data.get(0).getClass();
				Field[] fields = clazz.getDeclaredFields();
				Method method = null;
				Object o;
				int column = fields.length;
				int size = data.size();
				Object[][] os = new Object[size][column];
				for (int i = 0; i < size; i++) {
					Object[] hks = new Object[column];
					for (int j = 0; j < column; j++) {
						Field field = fields[j];
						//如果字段是私有的,那么必须要对这个字段设置
						field.setAccessible(true);
						String fieldName = field.getName();
						method = clazz.getDeclaredMethod(ClazzUtil.getMethodName(fieldName));
						method.setAccessible(true);
						o = method.invoke(data.get(i));
						if (fieldName.equals("state")) {
							int temp = null == o ? 1 : Integer.parseInt(o.toString());
							if (1 == temp) {
								hks[j] = "正在运行";
							} else {
								hks[j] = "禁止执行";
							}
						} else {
							boolean b = Contains.isArray(o);
							if (b) {
								//对象转数组
								int length = Array.getLength(o);
								StringBuilder sb = new StringBuilder();
								for (int k = 0; k < length; k++) {
									Object o1 = Array.get(o, k);
									sb.append(o1.toString());
								}
								//o = new String(sb.toString().getBytes(),"utf-8");
								o = sb.toString();
							}
							hks[j] = o;
						}
					}
					System.arraycopy(hks, 0, os[i], 0, hks.length);
					// for (int j = 0; j < hks.length; j++) {
					// 	os[i][j] = hks[j];
					// }
				}
				return os;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * file过滤器
	 * @param model excel *
	 * @return
	 */
	public static int openFile(String model) {
		// 1设定只能选择到文件夹 0只能选择文件
		Contains.JFILE.setFileSelectionMode(0);
		if ("excel".equals(model)) {
			ExcelFileFilter excelFilter = new ExcelFileFilter();
			Contains.JFILE.addChoosableFileFilter(excelFilter);
			Contains.JFILE.setFileFilter(excelFilter);
		}
		// 此句是打开文件选择器的触发语句
		return Contains.JFILE.showOpenDialog(null);
	}

	/**
	 * 打开文件选择框
	 * @param model 1设定只能选择到文件夹 0只能选择文件
	 * @return
	 */
	public static int openJfile(int model) {
		Contains.JFILE.setFileSelectionMode(model);
		// 此句是打开文件选择器的触发语句
		return Contains.JFILE.showOpenDialog(null);
	}

	/**
	 * 选择文件过后 设置文本内容
	 * @param jTextField
	 * @param model
	 */
	public static void setTextFile(JTextField jTextField,int model) {
		int i = openJfile(model);
		if (i == 1) {
			return;
		} else {
			String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
			jTextField.setText(absolutePath);
		}
	}

	/**
	 * 选择文件夹
	 * @return
	 */
	public static int openDir() {
		// 1设定只能选择到文件夹 0只能选择文件
		Contains.JFILE.setFileSelectionMode(1);
		// 此句是打开文件选择器的触发语句
		return Contains.JFILE.showOpenDialog(null);
	}

	/**
	 * 读取并执行定时任务
	 */
	public static void readTask() throws SchedulerException {
		// Contains.TASKS = JsonUtil.jsonToObject(Contains.TASKFPATH, TaskEntry.class);
		JSONArray array = JsonUtil.readJsonFileToJsonArray(Contains.TASKFPATH);
		if (array.size() > 0) {
			Contains.TASKS = JSONUtil.toList(array,TaskEntry.class);
		}

		//	执行任务
//		Scheduler scheduler= Contains.scheduler;
		if (CollUtil.isNotEmpty(Contains.TASKS)) {
			List<String> taskName = new ArrayList<>();
			for (TaskEntry task : Contains.TASKS) {
				//	一一绑定并执行
				boolean b = JobUtil.bingTask(task);
				if (!b) {
					taskName.add(task.getTaskName());
				}
			}
			if (CollUtil.isNotEmpty(taskName)) {
				Contains.DIALOG.showMessageDialog(Contains.parentWindow,CollUtil.join(taskName,",") + " 任务执行失败，请删除并结束所有的任务，之后重新添加！");
			}
		}
	}

	/**
	 * 设置窗口图标 （JDialog 和 JFrame类型不一样，虽然最终父类都是Window但是父类没有设置属性的方法）
	 * @param frame
	 */
	public static void setFrameTitle(JDialog frame,String title) {
		// 设置大小不可变 就能把标题栏的图标隐藏
		//frame.setResizable(false);
		//居中
		frame.setTitle("   " + title);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void setFrameTitle(JDialog frame,String title,String icon) {
		setFrameTitle(frame,title);
		frame.setResizable(true);
		ImageIcon icons=new ImageIcon(JsonUtil.toData(icon),"");
		frame.setIconImage(icons.getImage());
	}

	/**
	 * 读取配置
	 */
	public static void readConfig() {
//		List<Map<String,Object>> maps = JsonUtil.jsonToObject(Contains.JSONCONFIG, Map.class);
		Contains.CONFIG = JsonUtil.readJsonFileToObject(Contains.JSONCONFIG);
		if (null == Contains.CONFIG || null == Contains.CONFIG.get("runtime")) {
			Contains.CONFIG.put("runtime",1);
			JsonUtil.objectToJson(Contains.CONFIG,Contains.HOTKEYROOT,Contains.CGJSONFILENAME);
		} else {
			Integer runtime = (Integer) Contains.CONFIG.get("runtime");
			if (runtime <= 1) {
				Contains.CONFIG.put("runtime",2);
				JsonUtil.objectToJson(Contains.CONFIG,Contains.HOTKEYROOT,Contains.CGJSONFILENAME);
			}
		}
	}

	/**
	 * 注册热键
	 */
	public static void registerHotKey() {

		List<Hotkey> hotkeys = JsonUtil.jsonToObject(Contains.JSONPATH,Hotkey.class);
		Contains.HOTKEYS = hotkeys;
		if (hotkeys != null) {
			//启动之后要查询数据库  注册热键
			int size = hotkeys.size();
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					// 第一步：注册热键，热键标识，组合键（shift+Ctrl+其他）
					Hotkey o = (Hotkey) hotkeys.get(i);
					if (o.getHotkey() != null) {
						JIntellitype.getInstance().registerHotKey(o.getKId()+1, JIntellitype.MOD_CONTROL + JIntellitype.MOD_SHIFT,Contains.keycode(o.getHotkey()));
					}
				}
				HotkeyListener hotkeyListener = new HotkeyListener() {
					@Override
					public void onHotKey(int i) {
						if (i !=0 ) {
							try {
								Robot robot = new Robot();
								robot.keyRelease(KeyEvent.VK_CONTROL);
								robot.keyRelease(KeyEvent.VK_SHIFT);
								Thread.sleep(100);
							/*Map map = new HashMap();
							map.put("k_id = ", i);
							Hotkey o = (Hotkey) SqlUtil.setlectAll(map).get(0);*/
								Hotkey o = Contains.HOTKEYS.get(i);
								String kaction = o.getKaction();
								String encrypt = o.getEncrypt();
								if ("是".equals(encrypt)) {
									kaction = Contains.textDecode(kaction);
								}
								char[] uchars = kaction.toCharArray();
								inputKey(robot,uchars);
							} catch (AWTException | InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				};

				//添加监听
				JIntellitype.getInstance().addHotKeyListener(hotkeyListener);
			}
		}
	}

	/**
	 * 关闭当前窗口，如果当前窗口已经关闭，则关闭父窗口
	 * @param window
	 */
	public static void closeWindow(Container window) {
		if (window != null) {
			if (window instanceof JOptionPane) {
				window.setVisible(false);
				Contains.window = Contains.parentWindow;
			} else {
				if (window.isVisible()) {
					window.setVisible(false);
				} else {
					closeWindow(window.getParent());
				}
			}
		}
	}

	/**
	 * 键盘输入
	 * @param robot
	 * @param uchars
	 */
	public static void inputKey(Robot robot, char[] uchars) {
		try {
			for (char uchar : uchars) {
				switch (uchar) {
					case '!' :
						int c1 = Character.valueOf('1');
						// 按下
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c1);
						//弹起
						robot.keyRelease(c1);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '@' :
						int c2 = Character.valueOf('2');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c2);
						robot.keyRelease(c2);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '#' :
						int c3 = Character.valueOf('3');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c3);
						robot.keyRelease(c3);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '$' :
						int c4 = Character.valueOf('4');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c4);
						robot.keyRelease(c4);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '%' :
						int c5 = Character.valueOf('5');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c5);
						robot.keyRelease(c5);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '^' :
						int c6 = Character.valueOf('6');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c6);
						robot.keyRelease(c6);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '&' :
						int c7 = Character.valueOf('7');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c7);
						robot.keyRelease(c7);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '*' :
						int c8 = Character.valueOf('8');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c8);
						robot.keyRelease(c8);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '(' :
						int c9 = Character.valueOf('9');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c9);
						robot.keyRelease(c9);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case ')' :
						int c0 = Character.valueOf('0');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c0);
						robot.keyRelease(c0);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '_' :
						int c_1 = Character.valueOf('-');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_1);
						robot.keyRelease(c_1);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '+' :
						int c_2 = Character.valueOf('=');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_2);
						robot.keyRelease(c_2);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '{' :
						int c_3 = Character.valueOf('[');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_3);
						robot.keyRelease(c_3);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '}' :
						int c_4 = Character.valueOf(']');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_4);
						robot.keyRelease(c_4);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '|' :
						int c_5 = Character.valueOf('\\');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_5);
						robot.keyRelease(c_5);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case ':' :
						int c_6 = Character.valueOf(';');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_6);
						robot.keyRelease(c_6);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '"' :
						int c_7 = Character.valueOf('\'');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_7);
						robot.keyRelease(c_7);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '<' :
						int c_8 = Character.valueOf(',');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_8);
						robot.keyRelease(c_8);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '>' :
						int c_9 = Character.valueOf('.');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_9);
						robot.keyRelease(c_9);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '?' :
						int c_10 = Character.valueOf('/');
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(c_10);
						robot.keyRelease(c_10);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;
					case '~' :// 判断是不是- （tab）
						Thread.sleep(100);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						break;
					case '=' :// 判断是不是- （enter）
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						break;
					default:
						int character = Character.valueOf(uchar);
						if (Character.isUpperCase(uchar)) {
							robot.keyPress(KeyEvent.VK_CAPS_LOCK);
							robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
							robot.keyPress(character);
							robot.keyRelease(character);
							robot.keyPress(KeyEvent.VK_CAPS_LOCK);
							robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
						} else {
							String as = String.valueOf(uchar).toUpperCase();
							int character2 = Character.valueOf(as.toCharArray()[0]);
							robot.keyPress(character2);
							robot.keyRelease(character2);
						}
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			String IMG_PATH = "C:\\Users\\Administrator\\Desktop\\生活小技巧.gif";
			BufferedImage img = ImageIO.read(new File(IMG_PATH));
			ImageIcon icon = new ImageIcon(img);
			JLabel label = new JLabel(icon);
			JOptionPane.showMessageDialog(null, label);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
