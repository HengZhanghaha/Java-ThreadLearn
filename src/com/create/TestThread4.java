package com.create;

//多个线程同时操作同一个对象
//买火车票的例子

//发现问题：多线程在操作同一个资源时，线程不安全，数据紊乱。
public class TestThread4 implements Runnable{
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-> 拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老丝儿").start();
        new Thread(ticket,"黄牛").start();
    }
}
