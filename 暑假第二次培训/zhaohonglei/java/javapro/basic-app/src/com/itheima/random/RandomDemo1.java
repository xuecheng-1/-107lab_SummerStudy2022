package com.itheima.random;

import java.util.Random;

public class RandomDemo1 {
    public static void main(String[] args) {
        //目标：学习用java提供的随机数类Random
        //1.导包(公具自动写)
        //2.创建随机对象
        Random r  = new Random();
        //3.调用nextInt方法

        //选中指定行，crtl+alt+T==>循环指定行
        for (int i = 0;i<20;i++) {
            int data  = r.nextInt(10);
            System.out.println(data);
        }

        System.out.println("--------------------------");

    }
}
