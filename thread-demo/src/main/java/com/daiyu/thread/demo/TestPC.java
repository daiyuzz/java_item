package com.daiyu.thread.demo;

/**
 * created by dyx on 2022/1/5
 * 测试生产者消费者模型-利用缓冲区解决：管程法
 */
public class TestPC {


}

// 生产者
class Productor extends Thread{
    SynContainer container;


}

// 消费者
class Consumer extends Thread{

}

// 产品
class Chicken{

    int id;

    public Chicken(int id){
        this.id = id;
    }

}

//缓冲区
class SynContainer{
    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken){
        // 如果容器满了，就需要等待消费者消费
        if (count == chickens.length){
            // 通知消费者消费，生产者等待

        }
        // 如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count ++;

        // 可以通知消费者消费了
    }
    // 消费者消费产品
    public synchronized Chicken pop(){
        // 判断能否消费
        if (count == 0){
            // 等待生产者生产，消费者等待
        }
        // 如果可以消费
        count --;
        Chicken chicken = chickens[count];
        // 吃完了，通知生产者
        return chicken;

    }

}
