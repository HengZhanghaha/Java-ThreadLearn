package com.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//总结线程的创建方法
public class TestCreate {
    public static void main(String[] args) {
        //启动线程
        new MyThread1().start();

        new Thread(new MyThread2()).start();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread3());
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//1.继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("1：继承Thread类创建线程.");
    }
}

//2.实现Runnable接口
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("2.重写Runnable方法.");
    }
}

//3.实现Callable接口
class MyThread3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("3.实现Callable方法.");
        return 0;
    }
}
