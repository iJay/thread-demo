package org.example.www.threaddemo9;

public class Ticket implements Runnable{
    private int ticketNum = 100;

    @Override
    public void run() {
        // 如何解决多线程安全问题
        // 同步代码块 把可能出现线程安全问题的代码锁起来，只让一个线程执行即可
        // synchronized 默认是打开的，当一个线程进入同步代码块时，锁就关闭了 其他线程只能等待
        // 好处：解决了线程安全问题
        // 弊端：降低了效率，因为同一时间只能有一个线程进入同步代码块，其他线程只能等待
        // 这里的obj是锁对象，锁对象是任意的，但是必须保证多个线程使用的是同一个锁对象，这里的this就是同一个对象

         while (true) {
             synchronized (this) {
                 if (ticketNum > 0) {
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     ticketNum--;
                     System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余票数为：" + ticketNum);
                 } else {
                     break;
                 }
             }
         }
//        while (true){
//            if (ticketNum > 0){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                ticketNum--;
//                System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余票数为：" + ticketNum);
//            }else {
//                break;
//            }
//        }
    }
}
