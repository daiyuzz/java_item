package com.daiyu;


/**
 * daiyu
 * 2021/1/17
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();

        Thread.sleep(3500);
        tpt.stop();

    }
}


class TwoPhaseTermination {
    private Thread monitor;

    // 启动监控线程
    public void start() {
        monitor = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Thread current = Thread.currentThread();
                    if (current.isInterrupted()) {
                        System.out.println("料理后事");
                        break;
                    }
                    try {
                        Thread.sleep(1000); // 被打断情况1
                        System.out.println("执行监控记录"); // 被打断情况2
                    } catch (InterruptedException e) { // 当sleep 被打断时，打断标记被清除，在这里打断标记被置为假，需要重新打断一下
                        e.printStackTrace();
                        // 重新设置打断标记
                        current.interrupt();
                    }
                }
            }
        });

    }

    // 停止监控线程
    public void stop() {
        monitor.interrupt();

    }
}