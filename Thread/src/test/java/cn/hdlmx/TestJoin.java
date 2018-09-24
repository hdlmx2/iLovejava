package cn.hdlmx;

public class TestJoin implements Runnable {


    public static void main(String[] sure) throws InterruptedException {
        TestJoin tJ1 = new TestJoin();
        Thread T1 = new Thread(tJ1);
        Thread T2 = new Thread(tJ1);
        T1.setName("T1");
        T2.setName("T2");
        T1.setPriority(1);
        T2.setPriority(2);
        T1.start();
        T2.start();
        T1.join();
        T2.join();


        for (int j = 0; j < 50; j++) {
            System.out.println(Thread.currentThread().getName() + "..." + j);
        }


    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);
        }
    }
}