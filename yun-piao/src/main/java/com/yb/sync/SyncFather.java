package com.yb.sync;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class SyncFather {

	public static synchronized void fatherStatic() {
		System.out.println("SyncFather.fatherStatic");
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void father() {
		System.out.println("SyncFather.father");
	}
}
