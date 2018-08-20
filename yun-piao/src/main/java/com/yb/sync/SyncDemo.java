package com.yb.sync;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class SyncDemo {

	public static void main(String[] args) {
		new Thread(() -> {
			SyncChild.fatherStatic();
		}).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(() -> {
			synchronized (SyncChild.class) {
				SyncFather f = new SyncFather();
				f.father();
			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
