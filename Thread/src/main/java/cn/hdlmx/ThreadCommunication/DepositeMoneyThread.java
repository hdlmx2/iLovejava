package cn.hdlmx.ThreadCommunication;

public class DepositeMoneyThread implements Runnable {
    private Account account;
    private double amount;

    public DepositeMoneyThread(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposite(amount, i);
        }
    }
}
