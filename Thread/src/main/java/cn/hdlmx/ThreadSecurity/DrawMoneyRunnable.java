package cn.hdlmx.ThreadSecurity;

public class DrawMoneyRunnable implements Runnable {
    private Account account;
    private double drawAmount;

    public DrawMoneyRunnable(Account account, double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        if (drawAmount <= account.getBalance()) {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            System.out.println("取钱成功， 取出钱数为：" + drawAmount);
            double balance = account.getBalance() - drawAmount;
            account.setBalance(balance);
            System.out.println("余额为：" + balance);
        }

    }
}
