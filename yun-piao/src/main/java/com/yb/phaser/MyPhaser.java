package com.yb.phaser;

import java.util.concurrent.Phaser;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class MyPhaser extends Phaser {

	public MyPhaser(int num) {
		super(num);
	}

	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		System.out.println("阶段" + phase + "的" + registeredParties + "个线程, 已经全部完成");
//		if (phase == 3) {
//			return true;
//		}
		return super.onAdvance(phase, registeredParties);
	}
}
