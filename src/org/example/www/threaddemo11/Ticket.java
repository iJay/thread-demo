package org.example.www.threaddemo11;

public class Ticket implements Runnable{
    private static int ticketNum = 100;

    @Override
    public void run() {
        while(true) {
            synchronized (Ticket.class) {
               if (Thread.currentThread().getName().equals("窗口1")) {
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

               if (Thread.currentThread().getName().equals("窗口2")) {
                   Boolean result = sellTicket();
                   if (result) {
                       break;
                   }
               }
            }
        }
    }

    // 从这个案例可以看出 同步静态方法的锁对象是类名.class
    private static synchronized Boolean sellTicket() {
        if (ticketNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketNum--;
            System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余票数为：" + ticketNum);
            return false;
        } else {
            return true;
        }
    }
}
