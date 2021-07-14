package com.demo2.lambda;

//
/*
*** lambda表达式：适用于函数式接口
1.函数式接口
->任何接口，只包含唯一一个抽象方法
->可以通过lambda表达式创建该接口的对象。
    eg:
        public interface Runnable{
            public abstract void run();
        }
*/


public class TestLambda {

    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda22.");
        }
    }
    public static void main(String[] args) {
        //2.
        ILike like1 = new Like();
        like1.lambda();

        //3.
        ILike like2 = new Like2();
        like2.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda33.");
            }
        }
        ILike like3 = new Like3();
        like3.lambda();

        //5.匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda44.");
            }
        };
        like4.lambda();

        //6.使用lambda简化
        ILike like5 = ()->{
            System.out.println("I like lambda55.");
        };
        like5.lambda();


    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda.");
    }
}
