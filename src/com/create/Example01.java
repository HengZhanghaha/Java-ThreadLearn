package com.create;

//实战1：龟兔赛跑问题
public class Example01 implements Runnable{
    //冠军
    private static String winner;

    @Override
    public void run() {
        for (int i = 0;i <= 100;i++) {
            //判断
            if (gameOver(i)){
                break;
            }
            //手动干预,兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i % 49 == 10){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "->>跑出了第" + i + "步");
        }
    }
    private boolean gameOver(int steps){
        //冠军是否诞生？
        if (winner != null){
            return true;
        }
        //是否有冠军诞生？
        if (steps == 100){
            winner = Thread.currentThread().getName();
            System.out.println(winner + "是冠军！！！");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Example01 example01 = new Example01();

        new Thread(example01,"乌龟").start();
        new Thread(example01,"兔子").start();
    }
}
