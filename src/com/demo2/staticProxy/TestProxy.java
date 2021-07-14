package com.demo2.staticProxy;

/*
* 静态代理模式总结:
* 1.真实对象和代理对象都要实现同一个接口
* 2.代理对象代理真实对象的事
*
* 优点：
* 1.代理对象可以实现真实对象更多的方法
* 2.使真实对象专心做一件事
* */
public class TestProxy {
    public static void main(String[] args) {

        new Thread(()->System.out.println("订婚啦!!!")).start();
        new WeddingCompany(new You()).happyMarry();
    }
}

interface Marry{
    void happyMarry();
}

//真实类
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("老铁，恭喜你，结婚啦！");
    }
}

//代理类
class WeddingCompany implements Marry{
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结束了，来吧，结账....");
    }

    private void before() {
        System.out.println("之前，布置场景一下.............");
    }
}
