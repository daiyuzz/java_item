package com.daiyu.thread.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * created by dyx on 2022/1/30
 */
public class WrongInit {

    private Map<Integer, String> students;

    public WrongInit(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                students = new HashMap<>();
                students.put(1,"王晓梅");
                students.put(2,"钱二宝");
                students.put(3,"周三");
                students.put(4,"赵四");
            }
        }).start();
    }

    public Map<Integer, String> getStudents(){
        return students;
    }

    public static void main(String[] args) throws InterruptedException {
        WrongInit multiThreadsError6 = new WrongInit();
        Thread.sleep(1);
        System.out.println(multiThreadsError6.getStudents().get(1));

    }
}

/**
 * 只有当线程运行完 run() 方法中的全部赋值操作后，4名同学的全部信息才算是初始化完毕，可我们看主函数 main() 中，初始化 WrongInit类之后并没有进行任何休息直接打印1号同学信息
 * 实际上会发生空指针异常
 */
