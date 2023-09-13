package org.example.www.threaddemo1;


public class Demo{
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // start() 导致此线程开始执行; Java虚拟机调用此线程的run方法
        // run方法是用来封装被线程执行的代码
        long id = Thread.currentThread().getId();
        System.out.println("主线程" + id);
        myThread1.start();
        myThread2.start();
        // run方法直接调用相当于普通方法的调用，并未开启新的线程。
        // myThread1.run();
        // myThread2.run();
    }
}
