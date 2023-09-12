package org.example.www;

public class ThreadDemo4 {
    public static void main(String[] args) {
        // 线程是有默认名字的，格式为：Thread-序号
        MyThread4 myThread1 = new MyThread4("构造，线程1");
        MyThread4 myThread2 = new MyThread4("构造，线程2");

        // 设置线程名字
        // myThread1.setName("线程1");
        //  myThread2.setName("线程2");

        myThread1.start();
        myThread2.start();
    }
}

class MyThread4 extends Thread{
    public MyThread4(){
        super();
    }
    // 这里因为是子类，不能继承父类的构造方法，所以需要自己写一个构造方法
    // 通过super()调用父类的构造方法
    public MyThread4(String name){
        super(name);
    }
    @Override
    public void run(){
       for (int i = 0; i < 100; i++) {
           System.out.println(this.getName() + "@@@" + i);
       }
    }
}