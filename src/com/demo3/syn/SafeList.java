package com.demo3.syn;

import java.util.ArrayList;
import java.util.List;

public class SafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){   //这边加上synchronized，加上同步锁
                    list.add(Thread.currentThread().getName());
                };
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
