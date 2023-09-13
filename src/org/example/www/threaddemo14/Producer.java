package org.example.www.threaddemo14;

public class Producer extends Thread {
    @Override
    public void run() {
        // 生产者线程
        while(true) {
            synchronized (Desk.lock) {
                if (Desk.count >= 100) {
                    break;
                } else {
                    if (Desk.flag) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 生产者线程
                        Desk.count++;
                        System.out.println("生产者线程生产了第" + Desk.count + "个汉堡包");
                        Desk.flag = true;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
