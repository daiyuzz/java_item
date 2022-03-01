package com.daiyu.thread.demo;

/**
 * created by dyx on 2022/1/30
 */
public class WrongResult {

    static int i;

    public static void main(String[] args) throws InterruptedException{
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    i++;
                }
            }
        };
        Thread thread1 = new Thread(r);
        thread1.start();
        Thread thread2 = new Thread(r);
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
