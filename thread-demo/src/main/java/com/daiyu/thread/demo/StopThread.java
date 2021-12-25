package com.daiyu.thread.demo;

/**
 * created by dyx on 2021/12/25
 */
public class StopThread implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000){
            System.out.println("count=" + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}
