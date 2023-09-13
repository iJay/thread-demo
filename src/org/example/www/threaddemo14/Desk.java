package org.example.www.threaddemo14;

public class Desk {
    // 汉堡包的数量
    public static int count = 0;

    // 判断桌子上是否有饭
    public static boolean flag = false;

    // 唯一的锁对象
    public final static Object lock = new Object();
}
