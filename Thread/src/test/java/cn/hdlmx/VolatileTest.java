package cn.hdlmx;

public class VolatileTest {
    public static void main(String[] args) {
        MyRunable m1= new MyRunable();
        Thread t1=new Thread(m1);
        t1.setName("T1");
        Thread t2=new Thread(m1);
        t2.setName("T2");
        t1.setPriority(4);
        t2.setPriority(5);
        t1.start();
        t2.start();

    }
}
