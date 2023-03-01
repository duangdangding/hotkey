package com.lsh.hotkey.utils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.lsh.hotkey.entry.FilePojo;
import com.lsh.hotkey.entry.Hotkey;
import com.lsh.hotkey.entry.TaskEntry;
import com.lsh.hotkey.frame.IndexFrame;
import com.lsh.hotkey.frame.WaitFrame;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author: LuShao
 * @create: 2020-06-10 21:15
 **/
public class Contains {
	public static final SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat NORMOLYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final JFileChooser JFILE=new JFileChooser();
	public static final ExecutorService POOL = Executors.newFixedThreadPool(100);
	public static IndexFrame mainF = null;
	public static JOptionPane DIALOG = new JOptionPane();
	public static volatile WaitFrame wait;
	/**
	 * 记录打开的窗口
	 */
	public static Container window = null;
	public static Container parentWindow = null;

	/**
	 * 字体
	 */
	public static final Font F_S_0_14 = new Font("宋体", 0, 14);
	public static final Font F_YH_0_14 = new Font("Microsoft YaHei UI", 0, 14);
	public static final Font F_Y_0_14 = new Font("微软雅黑", 0, 14);
	public static final Font F_S_1_14 = new Font("宋体", 1, 14);
	public static final Font F_S_0_16 = new Font("宋体", 0, 16);
	public static final Font F_Y_0_16 = new Font("微软雅黑", 0, 16);
	public static final Font F_S_1_16 = new Font("宋体", 1, 16);
	public static final Font F_S_1_18 = new Font("宋体", 1, 18);
	public static final String SLABLE = "<html><body>";
	public static final String ELABLE = "</body></html>";

	/**
	 * 1 打开新增窗口 2 编辑窗口
	 */
	public static int AUSTATE = 0;
	public static int TASKSTATE = 0;
	/**
	 * 热键列表
	 */
	public static List<Hotkey> HOTKEYS = new ArrayList<>();
	/**
	 * 定时任务列表
	 */
	public static List<TaskEntry> TASKS = new ArrayList<>();
	// 配置项
	public static JSONObject CONFIG = new JSONObject();
	// 用户目录
	public static final String USERHOME = System.getProperties().getProperty("user.home") + File.separator;
	//根目录
	public static final String HOTKEYROOT = USERHOME + "hotkey" + File.separator;
	//热键文件名
	public static final String JSONFILENAME = "hotkey.json";
	//索引文件名
	public static final String MAKEFILENAME = "makefile.json";
	//配置文件名
	public static final String CGJSONFILENAME = "config.json";
	//配置文件名
	public static final String PROPILENAME = "set.properties";
	// 备份文件名
	public static final String BACKFILEN = "BK_key_"+YMDHMS.format(new Date())+".xlsx";
	//热键文件路径
	public static final String JSONPATH = HOTKEYROOT + JSONFILENAME;
	//索引文件路径
	public static final String MAKEPATH = HOTKEYROOT + MAKEFILENAME;
	//配置文件
	public static final String JSONCONFIG = HOTKEYROOT + CGJSONFILENAME;
	//配置文件
	public static final String SETPROP = HOTKEYROOT + PROPILENAME;
	// 备份文件夹
	public static final String BACKUPD = HOTKEYROOT + File.separator + "backup" + File.separator;
	// 备份文件路径
	//public static final String BACKFP = BACKUPD + BACKFILEN;
	//定时文件名
	public static final String TASKFILE = "task.json";
	// 定时任务文件路径
	public static final String TASKFPATH = HOTKEYROOT + File.separator + TASKFILE;
	//自动补全table头部
	public static final String[] COMPLETEH = new String[]{
			"ID", "热键", "内容", "注释", "加密"
	};
	// 定时任务头部
	public static final String[] TASKH = new String[]{
			"ID", "cron表达式", "执行类型", "提示消息", "程序列表", "CMD命令","注释","任务名"
	};
	// 定时任务头部
	public static final String[] SERCHFILEHEADER = new String[]{
			"文件路径", "文件名","文件类型", "文件大小(字节)", "创建时间"
	};

	private static final Base64.Decoder decoder = Base64.getDecoder();
	private static final Base64.Encoder encoder = Base64.getEncoder();

	private static final int F1 = 112;
	private static final int F2 = 113;
	private static final int F3 = 114;
	private static final int F4 = 115;
	private static final int F5 = 116;
	private static final int F6 = 117;
	private static final int F7 = 118;
	private static final int F8 = 119;
	private static final int F9 = 120;
	private static final int F10 = 121;
	private static final int F11 = 122;
	private static final int F12 = 123;

	// SchedulerFactory
	public static SchedulerFactory factory = new StdSchedulerFactory();
	// Scheduler
	public static Scheduler scheduler = null;
	public static Properties props = new Properties();

	/**
	 * 符合条件的 file集合
	 */
	public static List<FilePojo> FILES;
	public static List<String> FILESS;

	/**
	 * 判断对象是不是数组
	 * @param obj
	 * @return
	 */
	public static boolean isArray(Object obj) {
		if(obj == null) {
			return false;
		}
		return obj.getClass().isArray();
	}

	public static String yesNo(int i) {
		String result = "";
		switch (i) {
			case 0:
				result = "是";
				break;
			case 1:
				result = "否";
				break;
		}
		return result;
	}

	public static int keycode(String key) {
		int code = 0;
		switch (key) {
			case "F1" :
				code = 112;
				break;
			case "F2" :
				code = 113;
				break;
			case "F3" :
				code = 114;
				break;
			case "F4" :
				code = 115;
				break;
			case "F5" :
				code = 116;
				break;
			case "F6" :
				code = 117;
				break;
			case "F7" :
				code = 118;
				break;
			case "F8" :
				code = 118;
				break;
			case "F9" :
				code = 120;
				break;
			case "F10" :
				code = 121;
				break;
			case "F11" :
				code = 122;
				break;
			case "F12" :
				code = 123;
				break;
		}
		return code;
	}

	/**
	 * 把yyyy-MM-dd HH:mm:ss类型的日期转成ms
	 * @param time
	 * @return
	 */
	public static long getCtime(String time) {
		try {
			return Contains.NORMOLYMD.parse(time).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * Base64加密
	 *
	 * @param text
	 * @return
	 */
	public static String textEncode(String text) {
		byte[] textByte = new byte[0];
		try {
			textByte = text.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String encodedText = encoder.encodeToString(textByte);
		return encodedText;
	}

	/**
	 * Base64解密
	 *
	 * @param text
	 * @return
	 */
	public static String textDecode(String text) {
		String result = "";
		try {
			result = new String(decoder.decode(text), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 执行cmd命令
	 *
	 * @param cmd
	 */
	public static String exeCMD(String cmd) {
		BufferedReader br = null;
		String line = null;
		try {
			Runtime runtime = Runtime.getRuntime();
//			runtime.traceInstructions(true);
//			runtime.traceMethodCalls(true);
			System.out.println("CMD~~~" + cmd);
			Process p = runtime.exec(cmd);
			br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
			while ((line = br.readLine()) != null) {
				line += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return line;
	}

	/**
	 * 执行cmd命令
	 * @author lushao
	 * 2023/3/1 14:42
	 * @param command
	 * @return void
	 */
	public static void exec(String command) {
		System.out.println("开始执行任务：" + command);
		exec(command,"");
	}
	public static void exec(String cmd,String tarPath) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (StrUtil.isNotBlank(tarPath)) {
			processBuilder.directory(new File(tarPath));
		}

		// 设置为 true 后，错误会和标准输出一样输出
		processBuilder.redirectErrorStream(true);

		// 构建一个命令
		List<String> command = new ArrayList<>();
		// 该命令的位置，可以用 which 查找
		// command.add("cmd.exe");
		command.add("cmd");
		command.add("/c");
		command.add(cmd);
		processBuilder.command(command);

		try {
			Process process = processBuilder.start();
			InputStream is = process.getInputStream();
			// 使用 hutool 工具类 解析 inputStream
//            FastByteArrayOutputStream read = IoUtil.read(is);
			String read = IoUtil.read(is, Charset.forName("gbk"));
			System.out.println(read);
			// log.info(allFilename + " ：" + read);
			is.close();
			if(process.isAlive()){
				process.waitFor();
			}
		} catch (Exception e) {
			String message = e.getMessage();
			if (StrUtil.isNotBlank(message)) {
				if (message.contains("权限")) {
					message = "没有足够的权限执行命令，请以管理员权限运行程序。。。";
				}
				Contains.DIALOG.showMessageDialog(Contains.parentWindow,message);
			} else {
				Contains.DIALOG.showMessageDialog(Contains.parentWindow,"未知错误！");
			}
		}

	}

	/**
	 * 分组
	 * @param listmodel
	 * @param size
	 * @param maps
	 */
	public static void groupFile(FilePojo pojo,String name,Map<String,List<FilePojo>> maps) {
		if (maps.containsKey(name)) {
			maps.get(name).add(pojo);
		} else {
			List<FilePojo> files = new ArrayList<>();
			files.add(pojo);
			maps.put(name,files);
		}
	}

	/**
	 * 数字转汉字
	 * @param str
	 */
	public static String numToString(String str) {
		String[] split = str.split("");
		String result = "";
		for (int i = 0; i < split.length; i++) {
			String ind = split[i];
			switch (ind) {
				case "0" :
					result += "零";
					break;
				case "1" :
					result += "一";
					break;
				case "2" :
					result += "二";
					break;
				case "3" :
					result += "三";
					break;
				case "4" :
					result += "四";
					break;
				case "5" :
					result += "五";
					break;
				case "6" :
					result += "六";
					break;
				case "7" :
					result += "七";
					break;
				case "8" :
					result += "八";
					break;
				case "9" :
					result += "九";
					break;
			}
		}
		return result;
	}

	/**
	 * 去除map的value的List长度为1的map
	 * @param maps
	 */
	public static void disLenOne(Map<String,List<FilePojo>> maps) {
		Iterator<Map.Entry<String, List<FilePojo>>> it = maps.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<FilePojo>> next = it.next();
			List<FilePojo> value = next.getValue();
			if (value.size() < 2) {
				it.remove();
			}
		}
	}

	/**
	 * 开机自动启动
	 */
	/*private void startFolderMethod() {
		if(Platform.getInstance().isQualcomm()) {
			return;
		}
		String savePath = "";
		String osName = System.getProperty("os.name");
		String userHome = System.getProperty("user.home");
		if (osName.equals("Windows 7") || osName.equals("Windows 8") || osName.equals("Windows 10")
				||osName.equals("Windows Server 2012 R2")||osName.equals("Windows Server 2014 R2")
				||osName.equals("Windows Server 2016")){
			savePath=userHome+"\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
		}
		String appName = "bydTestManage-32.exe";
		String relativelyPath = System.getProperty("user.dir");
		System.setProperty("JSHORTCUT_HOME",relativelyPath);
		String exePath = relativelyPath + File.separator+"bydTestManage-32.exe";
		//logger.info("系统自启目录：" + savePath);
		//logger.info("exe文件路径：" + exePath);
		File file = new File(savePath + appName);
		if(file.exists()){
			return;
		}
		File exeFile = new File(exePath);
		File saveDir = new File(savePath);
		if(!exeFile.exists()||!saveDir.exists()){
			return;
		}
		try{
			JShellLink link=new JShellLink();
			link.setName(appName);
			link.setFolder(savePath);
			link.setPath(exePath);
			link.save();
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}*/

	/**
	 * 借助java.lang.ProcessBuilder打开 文件或者程序
	 * @throws IOException
	 */
	public static void useProcessBuilder(String file){
		//new ProcessBuilder("notepad.exe", "C:/Users/Jadyer/Desktop/test file/readme.txt").start();  
		List<String> commands = new ArrayList<String>();
		commands.add(file);
		//commands.add("F:/C.Project/便签.txt");  
		try {
			new ProcessBuilder(commands).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 借助java.awt.Desktop打开 
	 * @see 打开的目录或文件名中允许包含空格
	 */
	private static void useAWTDesktop(String file) throws IOException{
		Desktop.getDesktop().open(new File(file));
	}

	/**
	 * 根据时间（时:分:秒）
	 * @param time
	 * @return 返回秒
	 */
	public static int timeToSecond(String time) {
		String[] times = time.split(":");
		int second = 0;
		second += Integer.valueOf(times[0]) * 3600;
		second += Integer.valueOf(times[1]) * 60;
		second += Integer.valueOf(times[2]);
		return second;
	}

	public static void main(String[] args) {
		/*Contains contains = new Contains();
		Class<? extends Contains> aClass = contains.getClass();
		String simpleName = aClass.getSimpleName();
		System.out.println(simpleName);*/
//		String newName = "_.";
//		boolean matches = newName.matches("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");
//		boolean matches = newName.matches("[^(A-Za-z0-9\\\\u4e00-\\\\u9fa5_\\-\\.)]");
//		boolean matches = newName.matches("[^(A-Za-z0-9\\\\u4e00-\\\\u9fa5\\-)]");
//		System.out.println(matches);
//		String name = contains.getClass().getName();
//		System.out.println(name);
//		exeCMD("rename D:/test2/9fd0d135a0a4266ea19a95c216521979.jpg D:/test2/157.jpg");
		File file = new File("D:/test2/9fd0d135a0a4266ea19a95c216521979.jpg");
		boolean b = file.renameTo(new File("157.jpg"));

	}
}
