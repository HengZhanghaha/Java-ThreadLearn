package com.demo3.syn;

//线程不安全
//案例：买火车票
//改进：加上synchronized关键字，加上锁

public class SafeBuyTicket {
    public static void main(String[] args) {

        BuyTicket2 station = new BuyTicket2();

        new Thread(station,"大黄").start();
        new Thread(station,"黄牛党").start();
        new Thread(station,"老大哥").start();

    }
}

//买票
class BuyTicket2 implements Runnable{
    //票数
    private int ticketNum = 10;
    //外部停止标志
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            try {
                //模拟延时
                Thread.sleep(1000);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //买票
    //synchronized关键字，变成同步方法，锁的是this。
    private synchronized void buy(){
        if (ticketNum <= 0){
            flag = false;
            System.out.println("票买完了");
            return;
        }

        System.out.println(Thread.currentThread().getName() +
                " 拿到了第" + ticketNum-- + "票");
    }

}


