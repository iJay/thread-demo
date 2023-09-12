package org.example.www.threaddemo12;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
    private int ticketNum = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // 如何解决多线程安全问题
        // Lock锁 比synchronized更加灵活
        // Lock锁是一个接口，使用Lock接口中的实现类ReentrantLock
        // ReentrantLock类中的方法lock()和unlock()分别用来加锁和解锁
         while (true) {
             try {
                 lock.lock();
                 if (ticketNum > 0) {
                     Thread.sleep(100);
                     ticketNum--;
                     System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余票数为：" + ticketNum);
                 } else {
                     break;
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } finally {
                 // 在finally中是为了保证锁对象一定会被释放，不会出现死锁的情况
                 lock.unlock();
             }
         }
    }
}
