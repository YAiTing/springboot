package com.yb.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class MethodHandleDemo {

	public static String printStr(String string) {
		return "hello " + string;
	}

	public void print(String string) {
		System.out.println("hello " + string);
	}

//	public static void main(String[] args) throws Throwable {
//		//第一个参数是返回类型，后面是参数类型
//		MethodType methodType = MethodType.methodType(String.class, String.class);
//		MethodHandle methodHandle = MethodHandles.lookup().findStatic(MethodHandleDemo.class, "printStr", methodType);
//		String result = (String) methodHandle.invoke("sss");
//		System.out.println(result);
//
//		MethodType methodType1 = MethodType.methodType(void.class, String.class);
//		MethodHandleDemo demo = new MethodHandleDemo();
//		MethodHandle methodHandle1 = MethodHandles.lookup().findVirtual(MethodHandleDemo.class, "print", methodType1);
//		methodHandle1.invoke(demo, "bbb");
//	}

	public static void main(String[] args) throws Throwable {
//		MethodType methodType = MethodType.methodType(void.class, String.class, Integer.class);
//		MethodHandle mh = MethodHandles.lookup().findVirtual(Dog.class, "race", methodType);
//		System.out.println(mh.invoke(null));

		MethodType methodType = MethodType.methodType(void.class, String.class);
		MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Dog.class,"race",methodType);
		MethodHandle mh = methodHandle.bindTo(new Dog());
		MethodHandle mh1 = mh.bindTo("sss");
		mh1.invoke();
//		MethodHandles.lookup().unreflect(House.class.getMethod("race")).invoke();
	}

}
