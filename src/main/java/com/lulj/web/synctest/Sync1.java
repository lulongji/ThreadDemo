package com.lulj.web.synctest;

/**
 * @Description:
 * @Author: lulongji
 */
class Sync1 {

    public synchronized void test1() {
        System.out.println("test1开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1结束..");
    }

}

class MyThread1 extends Thread {

    Sync1 sync = new Sync1();

    public MyThread1(Sync1 sync) {
        this.sync = sync;
    }

    public void run() {
        sync.test1();
    }
}

class Main1 {
    public static void main(String[] args) {
        Sync1 sync = new Sync1();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread1(sync);
            thread.start();
        }

    }
}