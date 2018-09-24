package cn.hdlmx.customerAndProducter;

public class Producer implements Runnable {
    private volatile Warehouse warehouse;
    private static char nameStart = 'A';
    private volatile static boolean ifComplete = false;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (ifComplete == false) {
            product();
        }
    }

    public void product() {
        synchronized (warehouse) {
            //如果仓库不满的话，则添加
            if (warehouse.isFull() != true) {

                try {
                    String newName = (nameStart++) + "";
                    Product newProduct = new Product(newName);
                    warehouse.push(newProduct);
                    Thread.sleep(500);
                    System.out.println("[" + Thread.currentThread().getName() + "]已生产产品：" + newProduct.getName());
                    if ("Z".equals(newName)) {
                        ifComplete = true;
                        System.out.println("=========生产完成===========");
                    }
                    warehouse.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

                try {
                    System.out.println("[" + Thread.currentThread().getName() + "]仓库已满，正在等待...");
                    warehouse.wait();
                    System.out.println("[" + Thread.currentThread().getName() + "]等待结束，准备生产...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
