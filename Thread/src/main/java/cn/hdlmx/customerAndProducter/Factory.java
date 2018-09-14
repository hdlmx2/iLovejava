package cn.hdlmx.customerAndProducter;

public class Factory {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Customer customer = new Customer(warehouse);
        Producer producer = new Producer(warehouse);
        Thread TCustomer = new Thread(customer);
        Thread TProducer = new Thread(producer);
        TCustomer.setName("消费者");
        TProducer.setName("生产者");
       /* TCustomer.setPriority(Thread.NORM_PRIORITY);
        TProducer.setPriority(Thread.NORM_PRIORITY);*/
        TProducer.start();
        TCustomer.start();
    }
}
