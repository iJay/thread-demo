package org.example.www.threaddemo1;

class MyThread extends Thread{
    @Override
    public void run(){
       for (int i = 0; i < 100; i++) {
           System.out.println("线程" + this.getId() + ":" + i);
       }
    }
}