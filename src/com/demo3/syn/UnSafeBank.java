package com.demo3.syn;

//线程不安全
//案例2：不安全的银行取钱
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account("结婚基金",100);

        Bank bank1 = new Bank(account,50,"你自己");
        Bank bank2 = new Bank(account,100,"你对象");
        bank1.start();
        bank2.start();

    }
}

//账户
class Account{
    public String name;
    public int money;
    public Account(String name,int money){
        this.name = name;
        this.money = money;
        show();
    }
    private void show(){
        System.out.println("账户名:" + this.name + ",余额:" + this.money);
    }
}

//银行
class Bank extends Thread{
    public Account account;  //账户
    public int drawingMoney;  //取款金额
    public int nowMoney;  //手里的钱

    public Bank(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        if (this.account.money - this.drawingMoney < 0){
            System.out.println("钱不够了，真尴尬!!!!");
            return;
        }

        //模拟延时
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.account.money -= this.drawingMoney;
        nowMoney += drawingMoney;

        System.out.println(this.getName() + "取出" + this.drawingMoney
                +"钱，此时手里有" + this.nowMoney + ",账户余额:" + this.account.money);

    }
}