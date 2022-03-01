package com.daiyu.thread.demo;

/**
 * created by dyx on 2022/2/8
 */
public class MyDeadLock {

    Object o1 = new Object();
    Object o2 = new Object();

    public void thread1() throws InterruptedException {
        synchronized (o1) {
            Thread.sleep(500);
            synchronized (o2) {
                System.out.println("线程1成功拿到两把锁");
            }
        }
    }

    public void thread2() throws InterruptedException {
        synchronized (o2) {
            Thread.sleep(500);
            synchronized (o1) {
                System.out.println("线程2成功拿到两把锁");
            }
        }
    }

    public static void main(String[] args) {
        MyDeadLock myDeadLock = new MyDeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myDeadLock.thread1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    myDeadLock.thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}


/**
 * 假设两个线程几乎同时进入休息，休息完成后，线程1想要获取 o2 锁，线程2想要获取 o1 锁，这时便发生了死锁，
 * 两个线程不主动调和，也不主动退出，就这样死死地等待对方先释放资源，导致程序得不到任何结果也不能停止运行。
 */
