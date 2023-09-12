package org.example.www;

public class ThreadDemo2 {
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

class MyRunnable implements Runnable {
    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + id + ":" + i);
        }
    }
}