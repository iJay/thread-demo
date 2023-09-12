package org.example.www.threaddemo8;

public class Demo {
    public static void main(String[] args) {
        // 守护线程
        // 守护线程是为其他线程服务的线程
        // 当其他线程都执行完毕后，守护线程也会自动结束
        // 守护线程一般都是无限循环
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.setName("线程1");
        // 设置线程2为守护线程
        // 当线程1执行完毕后，线程2也会自动结束
        myThread2.setDaemon(true);
        myThread2.setName("线程2");

        // 为了效果明显 提高线程1的优先级
        myThread1.setPriority(Thread.MAX_PRIORITY);

        myThread1.start();
        myThread2.start();
    }
}
