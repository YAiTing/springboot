package com.yb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class ProxyDemo {

	public static void main(String[] args) {
		Student student = new Student();
//		Person person =  (Person)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), Student.class.getInterfaces(),
//				new StudentHandler(student));
		Person person =  (Person)Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), Student.class.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("我代理了" + method.getName());
						return method.invoke(student, args);
					}
				});
		String result = person.talk("hello");
		System.out.println(result);
	}
}
