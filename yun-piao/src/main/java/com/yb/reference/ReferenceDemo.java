package com.yb.reference;

import java.lang.ref.WeakReference;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class ReferenceDemo {

	public static void main(String[] args) {
		Object obj = new Object();
		WeakReference<Object> wf = new WeakReference<Object>(obj);
		obj = null;
		System.out.println(wf.get());
	}
}
