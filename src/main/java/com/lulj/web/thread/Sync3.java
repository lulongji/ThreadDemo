package com.lulj.web.thread;

/**
 * @Description:
 * @Author: lulongji
 */

class Sync3 {
    public void test3() {
        synchronized (Sync3.class) {
            System.out.println("test3开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test3结束..");
        }
    }

}

class MyThread3 extends Thread {

    public void run() {
        Sync3 sync = new Sync3();
        sync.test3();
    }
}

class Main3 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread3();
            thread.start();
        }
    }
}