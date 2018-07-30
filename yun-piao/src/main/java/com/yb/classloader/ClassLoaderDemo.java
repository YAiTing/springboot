package com.yb.classloader;

import java.lang.reflect.Method;

/**
 * @Author: yangb
 * @Description:
 */
public class ClassLoaderDemo {

	public static void main(String[] args) throws Exception {
		MyClassLoader classLoader = new MyClassLoader();
		Class c = classLoader.loadClass("com.yb.classloader.Test");
		if (c != null) {
			Object obj = c.newInstance();
			Method method = c.getDeclaredMethod("say");
			method.invoke(obj);
			System.out.println(obj.getClass().getClassLoader());
			System.out.println(obj.getClass().getClassLoader().getParent());
		}
	}
}
