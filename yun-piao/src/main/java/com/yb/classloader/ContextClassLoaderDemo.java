package com.yb.classloader;

import java.lang.reflect.Method;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class ContextClassLoaderDemo {
	public static void main(String[] args) throws Exception {
		MyClassLoader classLoader = new MyClassLoader();
		Class c = classLoader.loadClass("com.yb.classloader.Test");
		if (c != null) {
			Object obj = c.newInstance();
			Method method = c.getDeclaredMethod("say");
			method.invoke(obj);
			System.out.println(obj.getClass().getClassLoader());
		}

		MyClassLoader1 classLoader1 = new MyClassLoader1();
		Class c1 = classLoader1.loadClass("com.yb.classloader.Test");
		System.out.println(c1.equals(c));
		System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader());
		new Thread(() -> {
			try {
				System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader());
				Thread.currentThread().setContextClassLoader(classLoader1);
				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				Class tc = cl.loadClass("com.yb.classloader.Test");
				System.out.println(tc.getClassLoader());
				if (tc != null) {
					Object obj = tc.newInstance();
					Method method = tc.getDeclaredMethod("say");
					method.invoke(obj);
					System.out.println(obj.getClass().getClassLoader());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		System.in.read();
	}
}
