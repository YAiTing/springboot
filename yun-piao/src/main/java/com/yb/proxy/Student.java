package com.yb.proxy;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class Student implements Person {

	@Override
	public String talk(String name) {
		System.out.println("说：" + name);
		return "说完了";
	}
}
