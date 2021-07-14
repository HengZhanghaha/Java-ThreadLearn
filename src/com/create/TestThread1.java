package com.create;

//创建线程方法一:继承Thread类，重写run()方法，调用.start()开启线程

//总结：  线程开启不一定立即执行，有CPU调度执行
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<100;i++){
            System.out.println("我是run()--> " + i);
        }
    }

    public static void main(String[] args) {
        //main,主线程
        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //使用.start()方法开启线程
        testThread1.start();

        for (int i = 0;i<1000;i++){
            System.out.println("main()->> " + i);
        }
    }
}
