package com.demo2.ThreadPriority;

//线程优先级
public class TestPriority{
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "->>" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(Thread.NORM_PRIORITY);
        t3.start();

        t4.setPriority(8);
        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();

    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->>" + Thread.currentThread().getPriority());
    }
}
