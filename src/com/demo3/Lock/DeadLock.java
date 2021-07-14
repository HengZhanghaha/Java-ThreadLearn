package com.demo3.Lock;

//死锁案例：两个女生化妆
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup("灰姑娘的水晶鞋",0);
        Makeup g2 = new Makeup("白雪公主的后妈",1);
        g1.start();
        g2.start();

    }
}

//口红
class Lipstack{
}

//镜子
class Mirror{
}

//化妆
class Makeup extends Thread{
    //确保镜子和口红唯一，用static
    static Lipstack lipstack = new Lipstack();
    static Mirror mirror = new Mirror();

    public String name;
    public int choice;
    public Makeup(String name,int choice){
        this.name = name;
        this.choice = choice;
    }

    @Override
    public void run() {
        makeup();
    }

    //注:同步锁只能锁一个，且不能嵌套
    private void makeup(){
        if (this.choice == 0){
            synchronized (mirror){
                System.out.println(this.name + "先拿到了镜子！！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstack){
                System.out.println(this.name + "又拿到了口红.....");
            }
        }else {
            synchronized (lipstack){
                System.out.println(this.name+ "先拿到了口红！！");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror){
                System.out.println(this.name + "又拿到了镜子.....");
            }
        }
    }
}
