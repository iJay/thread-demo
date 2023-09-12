package org.example.www;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        System.out.println("主线程" + id);
        // 线程开启之后需要执行里面的call方法
        MyCallable myCallable = new MyCallable();
        // FutureTask是一个包装器，它通过接受Callable来创建，它同时实现了Future和Runnable接口。
        // 因为实现了Runnable接口，所以它可以直接被Thread所调用。
        // 因为实现了Future接口，所以它可以得到一个Callable的返回值。
        // 这里的泛型参数表示call方法的返回值类型。
        // 获取线程执行完毕之后的结果，也可以作为参数传递给Thread对象。
        FutureTask<Integer> task1 = new FutureTask<Integer>(myCallable);
        FutureTask<Integer> task2 = new FutureTask<Integer>(myCallable);
        // 创建一个线程对象，并把参数传递给这个线程
        Thread thread1 = new Thread(task1, "线程1");
        Thread thread2 = new Thread(task2, "线程2");

        // 启动线程，调用参数对象中的run方法
        // thread1.start();
        // thread2.start();

        try {
            // 获取线程执行完毕之后的结果
            // 这里get方法会阻塞主线程，直到线程1和线程2执行完毕并返回结果
            // 所以get方法应该放在start方法之后，否则会阻塞主线程，导致线程1和线程2无法执行
            Integer result1 = task1.get();
            Integer result2 = task2.get();
            System.out.println("线程1的返回值：" + result1);
            System.out.println("线程2的返回值：" + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 启动线程，调用参数对象中的run方法
         thread1.start();
         thread2.start();
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        long id = Thread.currentThread().getId();
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + id + ":" + i);
        }
        // 返回值表示线程执行的结果
        return 200;
    }
}