package com.PC;

//生产者消费者问题:信号灯法
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0){
                this.tv.play("快乐大本营！！");
            }
            else {
                this.tv.play("广告，纵享丝滑............");
            }
        }
    }
}
//观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {

        this.tv.watch();
    }
}
//节目：演员表演，观众等待 T。反之亦然，F。
class TV{
    //节目
    String show;
    //标志
    boolean flag = true;

    //表演
    public synchronized void play(String show){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员表演了:" + show);
        //通知观众观看 ，演员等待
        this.notifyAll();
        this.show = show;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了：" + this.show);

        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}
