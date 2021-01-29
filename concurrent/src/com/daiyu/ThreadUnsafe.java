package com.daiyu;


import java.util.ArrayList;


public class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>();

    public void mehtod1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            // 临界区，会产生竟态条件
            method2();
            method3();
        }
    }

    private void method2(){
        list.add("1");
    }

    private void method3(){
        list.remove(0);
    }
}
