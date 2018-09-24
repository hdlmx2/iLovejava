package cn.hdlmx.ThreadSecurity;

public class ThreadTest {
    public static void main(String[] args) {
        Account account = new Account("123456", 1000);
        DrawMoneyRunnable drawMoneyRunnable = new DrawMoneyRunnable(account, 700);
        Thread myThread1 = new Thread(drawMoneyRunnable);
        Thread myThread2 = new Thread(drawMoneyRunnable);
        myThread1.setName("T1");
        myThread2.setName("T2");
        myThread1.setPriority(1);
        myThread2.setPriority(5);
        myThread1.start();
        myThread2.start();

    }
}
