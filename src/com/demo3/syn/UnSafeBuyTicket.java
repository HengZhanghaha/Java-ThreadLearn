package com.demo3.syn;

//线程不安全
//案例：买火车票
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"大黄").start();
        new Thread(station,"黄牛党").start();
        new Thread(station,"老大哥").start();
    }
}

//买票
class BuyTicket implements Runnable{
    //票数
    private int ticketNum = 10;
    //外部停止标志
    private boolean flag = true;
    @Override
    public void run() {
            while (flag){
                try {
                    buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    //买票
    private void buy() throws InterruptedException {
        if (ticketNum <= 0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() +
                " 拿到了第" + ticketNum-- + "票");
    }

}

