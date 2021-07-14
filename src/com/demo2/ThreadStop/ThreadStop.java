package com.demo2.ThreadStop;

public class ThreadStop implements Runnable{
    //1.定义一个表示位
    private boolean flag = true;
    @Override
    public void run() {
        int i = 1;
        while (flag){
            System.out.println("线程在跑呢 "+i++);
        }
    }

    //2.重写stop()方法
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();

        new Thread(threadStop).start();

        for (int i = 0; i < 1000; i++) {
            if (i == 900){
                threadStop.stop();
                System.out.println("该结束了!!!..............");
            }

        }
    }
}
