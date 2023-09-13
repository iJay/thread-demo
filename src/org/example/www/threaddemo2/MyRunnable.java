package org.example.www.threaddemo2;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + id + ":" + i);
        }
    }
}