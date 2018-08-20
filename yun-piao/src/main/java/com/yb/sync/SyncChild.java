package com.yb.sync;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class SyncChild extends  SyncFather {

	@Override
	public synchronized void father() {
		System.out.println("SyncChild.father");
	}

	public synchronized void child() {
		System.out.println("SyncChild.child");
	}

}
