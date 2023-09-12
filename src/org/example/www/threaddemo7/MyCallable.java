package org.example.www.threaddemo7;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + name + ":" + i);
        }
        return 200;
    }
}
