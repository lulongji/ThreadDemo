package com.lulj.web.thread;

/**
 * @Description:
 * @Author: lulongji
 */

class Sync2 {
	public void test2() {
		synchronized (this) {
			System.out.println("test2开始..");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("test2结束..");
		}
	}

}

class MyThread2 extends Thread {

	public void run() {
		Sync2 sync = new Sync2();
		sync.test2();
	}
}

class Main2 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread2();
			thread.start();
		}
	}
}