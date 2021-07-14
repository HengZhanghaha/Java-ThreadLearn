package com.demo2.lambda;

//lambda表达式也可以带参数

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love1 = (a)->{
            System.out.println("I love you" + a);
        };
        love1.love(2);
    }

}
interface ILove{
    void love(int a);
}
