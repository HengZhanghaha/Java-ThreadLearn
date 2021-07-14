package com.demo2.ThreadSleep;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时：
public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
        //1.模拟倒计时
//        TestSleep2.tenDown();

        //2.打印当前时间
        Date time = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(time));
            time = new Date(System.currentTimeMillis());//更新时间
        }

    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0){
                break;
            }
        }
    }
}
