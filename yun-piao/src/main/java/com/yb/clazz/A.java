package com.yb.clazz;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class A {

	private int score;

	public static String b = "b";

	public static final String a = "a";

	public static final int i = ThreadLocalRandom.current().nextInt(10);

	static {
		System.out.println("class a clinit");
	}
}
