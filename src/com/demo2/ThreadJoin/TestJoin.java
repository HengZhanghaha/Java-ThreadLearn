package com.demo2.ThreadJoin;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip说：" + i + "..........");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 50; i++) {

            if (i == 20){
                thread.join();
            }
            System.out.println("main: " + i);

        }

    }
}
