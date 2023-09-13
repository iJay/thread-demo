package org.example.www.threaddemo4;

class MyThread extends Thread{
    public MyThread(){
        super();
    }
    // 这里因为是子类，不能继承父类的构造方法，所以需要自己写一个构造方法
    // 通过super()调用父类的构造方法
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
       for (int i = 0; i < 100; i++) {
           System.out.println(this.getName() + "@@@" + i);
       }
    }
}