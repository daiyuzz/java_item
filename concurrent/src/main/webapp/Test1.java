package main.webapp;



/**
 * daiyu
 * 2021/1/15
 */
public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new Thread("thread1"){
            @Override
            public void run() {
                System.out.println("running");
            }
        };
        t1.start();
        System.out.println("running");
    }
}
