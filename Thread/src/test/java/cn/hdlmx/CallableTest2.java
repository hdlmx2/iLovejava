package cn.hdlmx;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest2 {
    public static void main(String[] args) {
        Callable<Integer> callable2 = new MyCallable2();
        FutureTask<Integer> ft = new FutureTask<>(callable2);
        Thread t = new Thread(ft);
        t.start();

        try {
            int sum = ft.get();
            System.out.println("sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
