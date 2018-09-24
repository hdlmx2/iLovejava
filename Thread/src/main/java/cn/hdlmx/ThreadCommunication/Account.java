package cn.hdlmx.ThreadCommunication;

public class Account {
    private String accountNo;
    private double balance;
    // 标识账户中是否已有存款
    private boolean flag = false;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    /*
     * 存钱
     * */

    public synchronized void deposite(double depositeAmount, int i) {
        if (flag == true) {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始要执行wait操作" + " -- i=" + i);
                wait();
                System.out.println(Thread.currentThread().getName() + " 执行了wait操作" + " -- i=" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            //开始存钱
            System.out.println(Thread.currentThread().getName() + " 存款:" + depositeAmount + " -- i=" + i);
            setBalance(balance + depositeAmount);
            flag = true;
            notifyAll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-- 存钱 -- 执行完毕" + " -- i=" + i);
        }
    }

    /*
     * 取钱
     * */
    public synchronized void draw(double drawAmount, int i) {
        if (!flag) {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始要执行wait操作" + " 执行了wait操作" + " -- i=" + i);
                wait();
                System.out.println(Thread.currentThread().getName() + " 执行了wait操作" + " 执行了wait操作" + " -- i=" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 开始取钱
            System.out.println(Thread.currentThread().getName() + " 取钱：" + drawAmount + " -- i=" + i);
            setBalance(getBalance() - drawAmount);
            flag = false;
            /*
             * 通知其他线程
             * */
            notifyAll();
            System.out.println(Thread.currentThread().getName() + "-- 取钱 -- 执行完毕" + " -- i=" + i); // 3
        }
    }

    public Account() {
    }


    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
