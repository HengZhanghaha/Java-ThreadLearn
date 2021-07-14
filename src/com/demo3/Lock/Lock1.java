package com.demo3.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Lock1 {
    public static void main(String[] args) {

        BuyTicket3 station = new BuyTicket3();

        new Thread(station,"大黄").start();
        new Thread(station,"黄牛党").start();
        new Thread(station,"老大哥").start();

    }
}

//买票
class BuyTicket3 implements Runnable{
    //票数
    private int ticketNum = 10;
    //外部停止标志
    private boolean flag = true;

    //写个锁
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        while (flag){
            lock.lock();
            try {
                //模拟延时
                Thread.sleep(1000);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }

    }

    //买票
    private  void buy(){
        if (ticketNum <= 0){
            flag = false;
            return;
        }

        System.out.println(Thread.currentThread().getName() +
                " 拿到了第" + ticketNum-- + "票");
    }

}
