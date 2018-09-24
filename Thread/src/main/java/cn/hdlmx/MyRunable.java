package cn.hdlmx;

public class MyRunable implements Runnable {
    private volatile int i = 0;
    private volatile boolean stop=false;

    @Override
    public void run() {
        for (i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
