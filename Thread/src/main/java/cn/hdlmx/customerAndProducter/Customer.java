package cn.hdlmx.customerAndProducter;

public class Customer implements Runnable {
    private volatile Warehouse warehouse;
    private volatile boolean ifComplete = false;

    public Customer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {

        while (ifComplete == false) {
            customer();
        }
    }

    public void customer() {
        synchronized (warehouse) {
            if (warehouse.isEmpty() == true) {
                //如果仓库为空，则消费者线程等待
                try {
                    System.out.println();
                    System.out.println("[" + Thread.currentThread().getName() + "]仓库为空，正在等待...");
                    warehouse.wait();
                    //notifyAll();
                    System.out.println("[" + Thread.currentThread().getName() + "]等待结束，准备取货...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    Product product = warehouse.getProduct();
                    Thread.sleep(500);
                    System.out.println("[" + Thread.currentThread().getName() + "]已取得产品：" + product.getName());
                    if ("Z".equals(product.getName())) {
                        ifComplete = true;
                        System.out.println("=========消费完成===========");
                    }
                    warehouse.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
