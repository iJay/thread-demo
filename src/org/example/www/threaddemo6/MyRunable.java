package org.example.www.threaddemo6;

public class MyRunable implements Runnable{
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            // 这里只能通过try catch来处理异常
            // 因为接口中的run方法没有抛出异常
            // 如果一个类或者接口方法没有抛出异常，那么其子类或者实现类的方法也不能抛出异常
            try {
                // 休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + name + "-----" + i);
        }
    }
}
