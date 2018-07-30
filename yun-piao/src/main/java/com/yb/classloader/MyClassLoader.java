package com.yb.classloader;

import java.io.*;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class MyClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File file = new File("D://", fileName);
		try {
			FileInputStream is = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			while((len = is.read()) != -1) {
				bos.write(len);
			}
			byte[] data = bos.toByteArray();
			return defineClass(name, data,0, data.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
		return super.findClass(name);
	}

	//获取要加载 的class文件名
	private String getFileName(String name) {
		int index = name.lastIndexOf('.');
		if(index == -1){
			return name+".class";
		}else{
			return name.substring(index+1)+".class";
		}
	}
}
