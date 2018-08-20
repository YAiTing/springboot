package com.yb.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
//		interrupt();
	}

	private static void interrupt() throws InterruptedException {
		Thread t = new Thread(()->{
			BlockingQueue<String> q = new ArrayBlockingQueue<>(10);
			try {
				q.take();
			} catch (InterruptedException e) {
				System.out.println("中断take");
			}
		});
		t.start();
		Thread.sleep(10000);
		t.interrupt();
		Thread.sleep(10000000);
	}

}
