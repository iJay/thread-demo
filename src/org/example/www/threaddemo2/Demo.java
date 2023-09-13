package org.example.www.threaddemo2;

public class Demo {
    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        System.out.println("主线程" + id);
        // 创建参数对象
       MyRunnable myRunnable = new MyRunnable();
        // 创建一个线程对象，并把参数传递给这个线程
        Thread thread1 = new Thread(myRunnable, "线程1");
        Thread thread2 = new Thread(myRunnable, "线程2");
        // 启动线程，调用参数对象中的run方法
        thread1.start();
        thread2.start();
    }
}