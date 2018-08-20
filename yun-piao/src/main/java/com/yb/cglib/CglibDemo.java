package com.yb.cglib;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class CglibDemo {

	public static void main(String[] args) {
		User user = new User();
		ProxyFactory factory = new ProxyFactory(user);
		User proxy = (User)factory.getProxyInstance();
		proxy.talk("hello");
	}
}
