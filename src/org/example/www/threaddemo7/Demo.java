package org.example.www.threaddemo7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程优先级
        // 线程优先级的范围是1-10，默认值是5
        // 线程优先级越高，越有可能先执行
        // 线程优先级只是给CPU一个提示，CPU不一定会按照提示执行
        // 线程优先级高的线程不一定会先执行完毕
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> task1 = new FutureTask<Integer>(myCallable);
        FutureTask<Integer> task2 = new FutureTask<Integer>(myCallable);
        Thread thread1 = new Thread(task1, "线程1");
        Thread thread2 = new Thread(task2, "线程2");
        // 设置线程优先级
        thread1.setPriority(Thread.MIN_PRIORITY); // 1
        thread2.setPriority(Thread.MAX_PRIORITY); // 10
        thread1.start();
        thread2.start();
        Integer result1 = task1.get();
        System.out.println("线程1执行结果：" + result1);
        Integer result2 = task2.get();
        System.out.println("线程2执行结果：" + result2);
    }
}
