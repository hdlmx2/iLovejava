package cn.hdlmx.ThreadCommunication;

public class TestThread {
    public static void main(String[] args) {
        Account account = new Account("123456", 0);
        DepositeMoneyThread depositeMoneyThread = new DepositeMoneyThread(account, 700);
        DrawMoneyThread drawMoneyThread = new DrawMoneyThread(account, 700);
        Thread TdepositeMoney = new Thread(depositeMoneyThread);
        TdepositeMoney.setName("存钱线程");
        Thread TdrawMoney = new Thread(drawMoneyThread);
        TdrawMoney.setName("取钱线程");
        TdepositeMoney.start();
        TdrawMoney.start();


    }
}
