package org.example.www.threaddemo5;

public class Demo {
    public static void main(String[] args) {
        // 获取当前正在执行的线程对象的引用
        String name = Thread.currentThread().getName();
        System.out.println("主线程" + name);
    }
}
