package com.demo2.ThreadYield;

public class TestYield {


    public static void main(String[] args) {
        MyYeild myYeild = new MyYeild();
        new Thread(myYeild,"a").start();
        new Thread(myYeild,"b").start();
    }
}

class MyYeild implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始....");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程停止....");
    }
}
