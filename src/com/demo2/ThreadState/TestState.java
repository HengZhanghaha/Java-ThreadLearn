package com.demo2.ThreadState;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //new

        //运行状态
        thread.start();
        state = thread.getState(); //更新状态
        System.out.println(state);  //Run

        //只要线程不终止，就一直输出状态
        while (state != Thread.State.TERMINATED){

            Thread.sleep(100);
            state = thread.getState(); //更新状态
            System.out.println(state);
        }

    }
}
