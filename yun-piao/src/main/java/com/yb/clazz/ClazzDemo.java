package com.yb.clazz;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class ClazzDemo {

	public static void main(String[] args) throws Exception {
		System.out.println(A.a);
		System.out.println(A.b);
		System.out.println("after a");
		System.out.println(A.i);
		Class intclass = Integer.class;
		Class<Integer> integerClass = Integer.class;
		intclass = double.class;
//		Class c = A.class;
		Class clazz = Class.forName("com.yb.clazz.A");
		Object obj = clazz.newInstance();
		Object obj1 = clazz.newInstance();
		Field field = clazz.getDeclaredField("score");
		field.setAccessible(true);
		field.set(obj1, 5);
		System.out.println(field.get(obj1));
		System.out.println(field.toGenericString());
		System.out.println(field.getDeclaringClass().equals(clazz));
		System.out.println(field.getType());

	}


}
