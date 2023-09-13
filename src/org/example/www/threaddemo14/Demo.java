package org.example.www.threaddemo14;

public class Demo {
    public static void main(String[] args) {
        // 生产者消费者模式是一个十分经典的多线程协作模式
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        consumer.start();
        producer.start();
    }
}
