package com.demo3.syn;

public class SafeBank {
    public static void main(String[] args) {
        Account2 account = new Account2("结婚基金",300);

        Bank2 bank1 = new Bank2(account,50,"你自己");
        Bank2 bank2 = new Bank2(account,300,"你对象");
        Bank2 bank3 = new Bank2(account,30,"你儿子");
        bank1.start();
        bank2.setPriority(10);
        bank2.start();
        bank3.setPriority(1);
        bank3.start();

    }
}


//账户
class Account2{
    public String name;
    public int money;
    public Account2(String name,int money){
        this.name = name;
        this.money = money;
        show();
    }
    private void show(){
        System.out.println("账户名:" + this.name + ",余额:" + this.money);
    }
}

//银行
class Bank2 extends Thread{
    public Account2 account;  //账户
    public int drawingMoney;  //取款金额
    public int nowMoney;  //手里的钱

    public Bank2(Account2 account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        //同步块,锁住的量是需要增删改的量，加上同步锁
        synchronized (account){
            if (this.account.money - this.drawingMoney < 0){
                System.out.println(Thread.currentThread().getName() +"要取"+this.drawingMoney + ",余额:" + this.account.money +" ,钱不够了，真尴尬!!!!");
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
}
