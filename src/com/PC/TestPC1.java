package com.PC;

//生产者消费者问题：
  //并发协作模型：-->管程法
public class TestPC1 {
    public static void main(String[] args) {

        SynContainer container = new SynContainer();
    
//        Productor productor = new Productor(container);
//        Consumer consumer = new Consumer(container);
//        productor.start();
//        consumer.start();
        new Productor(container).start();
        new Consumer(container).start();


    }
}

//生产者
class Productor extends Thread{
    SynContainer container;
    public Productor(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡...........");
        }
    }
}

//消费者

class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + container.pop().id + "只鸡！！");
        }
    }
}
//产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //容器尺寸
    Chicken[] chickens = new Chicken[10];
    //计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，则生产者等待
        if (count == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满，放入产品
        chickens[count] = chicken;
        count++;

        //通知消费者开始消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0){
            //消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }

}
