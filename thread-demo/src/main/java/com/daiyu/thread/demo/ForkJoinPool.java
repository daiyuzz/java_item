package com.daiyu.thread.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * created by dyx on 2022/2/9
 */
public class ForkJoinPool {

    class Fibonacci extends RecursiveTask<Integer>{
        int n;

        public Fibonacci(int n){
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1){
                return n;
            }
            Fibonacci f1 = new Fibonacci(n-1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n-2);
            f2.fork();
            return f1.join() + f2.join();
        }
    }

}
