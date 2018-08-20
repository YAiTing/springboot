package com.yb.phaser;

import java.util.concurrent.Phaser;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class PhaserDemo {

	public static void main(String[] args) {
		int num = 3;
		Phaser phaser = new MyPhaser(num);
		for (int i = 0; i < num; i++) {
			new Thread(new PhaserThread(phaser)).start();
		}

	}

	static class PhaserThread implements Runnable {

		private Phaser phaser;

		public PhaserThread(Phaser phaser) {
			this.phaser = phaser;
		}

		@Override
		public void run() {
			System.out.println("线程" + Thread.currentThread().getName() + "完成了,阶段" + phaser.getPhase() + "的工作");
			phaser.arriveAndAwaitAdvance();
			System.out.println("线程" + Thread.currentThread().getName() + "完成了,阶段" + phaser.getPhase() + "的工作");
			phaser.arriveAndAwaitAdvance();
			System.out.println("线程" + Thread.currentThread().getName() + "完成了,阶段" + phaser.getPhase() + "的工作");
			phaser.arriveAndAwaitAdvance();
			System.out.println("线程" + Thread.currentThread().getName() + "完成了,阶段" + phaser.getPhase() + "的工作");
			phaser.arriveAndAwaitAdvance();
			System.out.println("线程" + Thread.currentThread().getName() + "完成了,阶段" + phaser.getPhase() + "的工作");
			phaser.arriveAndAwaitAdvance();
			System.out.println("线程" + Thread.currentThread().getName() + "完成了,阶段" + phaser.getPhase() + "的工作");
			phaser.arriveAndAwaitAdvance();
		}
	}
}
