package com.create;

// 创建线程方法二：实现Runnable接口，重写run方法，
// 然后，执行线程需要丢入Runnable接口实现类，调用start()方法

public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<100;i++){
            System.out.println("我是run()--> " + i);
        }
    }

    public static void main(String[] args) {
        //main,主线程
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程，代理
//        Thread thread = new Thread(testThread3);
//        thread.start();
        new Thread(testThread3).start();


        for (int i = 0;i<500;i++){
            System.out.println("这个是主main()->> " + i);
        }
    }
}
