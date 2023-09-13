package org.example.www.threaddemo4 ;


public class Demo {
    public static void main(String[] args) {
        // 线程是有默认名字的，格式为：Thread-序号
        MyThread  myThread1 = new MyThread ("构造，线程1");
        MyThread  myThread2 = new MyThread ("构造，线程2");

        // 设置线程名字
        // myThread1.setName("线程1");
        //  myThread2.setName("线程2");

        myThread1.start();
        myThread2.start();
    }
}