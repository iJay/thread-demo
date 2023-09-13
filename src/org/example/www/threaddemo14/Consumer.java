package org.example.www.threaddemo14;

public class Consumer extends Thread {
    @Override
    public void run() {
        // 消费者线程
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count >= 100) {
                    break;
                } else {
                    if (!Desk.flag) {
                        try {
                            // 使用什么对象当作锁对象，就使用什么对象调用wait和notifyAll方法
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 消费者线程
                        System.out.println("消费者线程消费了第" + Desk.count + "个汉堡包");
                        Desk.flag = false;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
