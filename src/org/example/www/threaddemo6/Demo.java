package org.example.www.threaddemo6;

public class Demo {
    public static void main(String[] args) {
        // 线程休眠
//        System.out.println("开始");
//        try {
//            // 主线程休眠5秒
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("结束");
        MyRunable myRunable = new MyRunable();
        Thread thread1 = new Thread(myRunable);
        Thread thread2 = new Thread(myRunable);
        thread1.start();
        thread2.start();
    }
}
