package com.yb.annotation;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * @Author: yangb
 * @Description: 反射
 * @Date: Created in 11:02 2017/12/8
 */
public class ReflectDemo {

	public static void main(String[] args) {
		B b = new B();
		Class<? extends B> bClass = b.getClass();
		Method[] list = bClass.getDeclaredMethods();
		Arrays.stream(list).forEach(System.out::println);
		System.out.println("==================");
		list = bClass.getMethods();
		Arrays.stream(list).forEach(System.out::println);
		System.out.println("==========Annotation========");
		Annotation[] l = bClass.getAnnotations();
		Arrays.stream(l).forEach(System.out::println);
		System.out.println("==================");
		l = bClass.getDeclaredAnnotations();
		Arrays.stream(l).forEach(System.out::println);
//		System.out.println(bClass.isAnnotationPresent(Cacheable.class));
//		System.out.println(bClass.isAnnotationPresent(Component.class));
//		System.out.println(bClass.isAnnotationPresent(XmlRootElement.class));
//		ParameterizedType type = (ParameterizedType)(bClass.getGenericSuperclass());
//		System.out.println(type.getActualTypeArguments()[0]);
//		System.out.println(bClass.getSuperclass());
//		System.out.println(C.class.isAssignableFrom(bClass));
//		System.out.println(System.getProperty("sun.boot.class.path"));
//		System.out.println(bClass.getClassLoader());
//		System.out.println(bClass.getClassLoader().getParent());
//		System.out.println(bClass.getClassLoader().getParent().getParent());
	}
	@Cacheable
	@XmlRootElement
	private static class A<T> extends C<T> {
		public void a(){}
		private void a1(){}
	}
	@Component
	private static class B extends A<Singleton> {
		public void b(){}
		private void b1(){}
	}

	private static class C<T> {

	}
}
