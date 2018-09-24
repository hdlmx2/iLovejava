package cn.hdlmx;

import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class TestStop {

    public static void main(String[] args) throws InterruptedException {
        MyCallable2 callable2 = new MyCallable2();
        FutureTask<Integer> fu = new FutureTask<>(callable2);
        Thread t = new Thread(fu);
        t.start();
        sleep(250);
        callable2.stopThread();
        t.join();
        System.out.println("线程退出!");
    }
}
