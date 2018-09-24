package cn.hdlmx;

import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<Integer> {
    private volatile boolean stop = false;

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 10000 && stop == false; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + i);
        }
        return sum;
    }

    public void stopThread() {
        this.stop = true;
    }
}
