package org.example.www.threaddemo13;

public class Demo {
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        // 这里当小明获取到了A锁，小红获取到了B锁，然后小明想要获取B锁，小红想要获取A锁，这时候就会发生死锁
        // 死锁：多个线程互相抱着对方需要的资源，然后形成僵持
        // 死锁出现的原因： 锁的嵌套
        new Thread(() -> {
            synchronized (objA) {
                System.out.println(Thread.currentThread().getName() + "小明获取到了A锁");
                synchronized (objB) {
                    System.out.println(Thread.currentThread().getName() + "小明获取到了B锁");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (objB) {
                System.out.println(Thread.currentThread().getName() + "小红获取到了B锁");
                synchronized (objA) {
                    System.out.println(Thread.currentThread().getName() + "小红获取到了A锁");
                }
            }
        }).start();
    }
}
