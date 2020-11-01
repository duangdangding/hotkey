package com.lsh.hotkey.utils;

import org.quartz.JobExecutionContext;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Map;

/**
 * @Description: 反射util
 * @author: LuShao
 * @create: 2020-07-14 17:08
 **/
public class ClazzUtil {

	public static final String CLASSSTR1 = "package com.lsh.hotkey.utils;" +
			"import com.lsh.hotkey.utils.Contains;" +
			"import org.quartz.Job;" +
			"import com.lsh.hotkey.frame.IndexFrame;" +
			"import org.quartz.JobExecutionContext;" +
			"import org.quartz.JobExecutionException;" +
			"import javax.swing.JOptionPane;" +
			"public class ";
	public static final String CLASSSTR2 = " implements Job {@Override " +
			"public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {";
	public static final String CLASSSTR3 = "}}";

	public final static String JAVA = ".java";// Java源文件的扩展名

	/**
	 * 得到属性对应的set方法名
	 * @param field
	 * @return
	 */
	public static String setMethodName(String field) {
		return "set"+field.substring(0,1).toUpperCase()+field.substring(1);
	}
	
	/**
	 * 得到属性对应的set方法名
	 * @param field
	 * @return
	 */
	public static String getMethodName(String field) {
		return "get"+field.substring(0,1).toUpperCase()+field.substring(1);
	}

	public static Class testInvoke(String className, String source) throws Exception{
		source = CLASSSTR1 + className + CLASSSTR2 + source + CLASSSTR3;
		// 对source进行编译生成class文件存放在Map中，这里用bytecode接收
		Map<String, byte[]> bytecode = DynamicLoader.compile(className + JAVA,source);

		// 加载class文件到虚拟机中，然后通过反射执行
		@SuppressWarnings("resource")
		DynamicLoader.MemoryClassLoader classLoader = new DynamicLoader.MemoryClassLoader(bytecode);
		Class<?> clazz = classLoader.loadClass(className);
		Object object = clazz.newInstance();
		
		// 
		Method method = clazz.getMethod("execute", JobExecutionContext.class);
		//JobExecutionContext jobExecutionContext = SwingUtil.scheduler.getCurrentlyExecutingJobs().get(0);
		//JobExecutionContext jobExecutionContext = null;
		//method.invoke(object,jobExecutionContext);

		/*// 得到add方法
		Method addMethod = clazz.getMethod("add", int.class, int.class);
		Object returnValue = addMethod.invoke(object, 1024, 1024);
		System.out.println(Thread.currentThread().getName() + ": " + "1024 + 1024 = " + returnValue);

		// 因为在main方法中，调用了add和sayHello方法，所以直接调用main方法就可以执行两个方法
		Method mainMethod = clazz.getDeclaredMethod("main", String[].class);
		mainMethod.invoke(null, (Object) new String[] {});*/
		return clazz;
	}

	public static URI toURI(String name) {
		File file = new File(name);
		if (file.exists()) {// 如果文件存在，返回他的URI
			return file.toURI();
		} else {
			try {
				final StringBuilder newUri = new StringBuilder();
				newUri.append("mfm:///");
				newUri.append(name.replace('.', '/'));
				if (name.endsWith(JAVA)) {
					newUri.replace(newUri.length() - JAVA.length(), newUri.length(), JAVA);
				}
				return URI.create(newUri.toString());
			} catch (Exception exp) {
				return URI.create("mfm:///com/sun/script/java/java_source");
			}
		}
	}

}
