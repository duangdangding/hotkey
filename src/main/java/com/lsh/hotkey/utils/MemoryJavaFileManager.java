package com.lsh.hotkey.utils;

import javax.tools.*;
import java.io.*;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 将编译好的.class文件保存到内存当中，这里的内存也就是map映射当中
 * @author: LuShao
 * @create: 2020-07-17 15:33
 **/
@SuppressWarnings("rawtypes")
public class MemoryJavaFileManager extends ForwardingJavaFileManager {

	private final static String EXT = ".java";// Java源文件的扩展名
	private Map<String, byte[]> classBytes;// 用于存放.class文件的内存

	@SuppressWarnings("unchecked")
	public MemoryJavaFileManager(JavaFileManager fileManager) {
		super(fileManager);
		classBytes = new HashMap<String, byte[]>();
	}

	public Map<String, byte[]> getClassBytes() {
		return classBytes;
	}

	@Override
	public void close() throws IOException {
		classBytes = new HashMap<String, byte[]>();
	}

	@Override
	public void flush() throws IOException {
	}

	/**
	 * 一个文件对象，用来表示从string中获取到的source，一下类容是按照jkd给出的例子写的
	 */
	private static class StringInputBuffer extends SimpleJavaFileObject {
		// The source code of this "file".
		final String code;

		/**
		 * Constructs a new JavaSourceFromString.
		 *
		 * @param name 此文件对象表示的编译单元的name
		 * @param code 此文件对象表示的编译单元source的code
		 */
		StringInputBuffer(String name, String code) {
			super(ClazzUtil.toURI(name), Kind.SOURCE);
			this.code = code;
		}

		@Override
		public CharBuffer getCharContent(boolean ignoreEncodingErrors) {
			return CharBuffer.wrap(code);
		}

		@SuppressWarnings("unused")
		public Reader openReader() {
			return new StringReader(code);
		}
	}

	/**
	 * 将Java字节码存储到classBytes映射中的文件对象
	 */
	private class ClassOutputBuffer extends SimpleJavaFileObject {
		private String name;

		/**
		 * @param name className
		 */
		ClassOutputBuffer(String name) {
			super(ClazzUtil.toURI(name), Kind.CLASS);
			this.name = name;
		}

		@Override
		public OutputStream openOutputStream() {
			return new FilterOutputStream(new ByteArrayOutputStream()) {
				@Override
				public void close() throws IOException {
					out.close();
					ByteArrayOutputStream bos = (ByteArrayOutputStream) out;

					// 这里需要修改
					classBytes.put(name, bos.toByteArray());
				}
			};
		}
	}

	@Override
	public JavaFileObject getJavaFileForOutput(
			JavaFileManager.Location location, String className,
			JavaFileObject.Kind kind, FileObject sibling) throws IOException {
		if (kind == JavaFileObject.Kind.CLASS) {
			return new ClassOutputBuffer(className);
		} else {
			return super.getJavaFileForOutput(location, className, kind,
					sibling);
		}
	}

	static JavaFileObject makeStringSource(String name, String code) {
		return new StringInputBuffer(name, code);
	}

}
