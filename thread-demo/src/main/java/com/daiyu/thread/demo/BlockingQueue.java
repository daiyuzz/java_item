package com.daiyu.thread.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by dyx on 2022/1/27
 */
public class BlockingQueue {

    Queue<String> buffer = new LinkedList<>();

    public void give(String data) {
        synchronized (this) {
            buffer.add(data);
            notify();
        }
    }

    public String take() throws InterruptedException {
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }
            return buffer.remove();
        }
    }

}
