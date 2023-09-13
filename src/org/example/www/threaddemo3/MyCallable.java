package org.example.www.threaddemo3;

import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        long id = Thread.currentThread().getId();
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + id + ":" + i);
        }
        // 返回值表示线程执行的结果
        return 200;
    }
}