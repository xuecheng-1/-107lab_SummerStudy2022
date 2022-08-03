package com.itheima.create;

public class ArrayDemo2 {
    public static void main(String[] args) {
        //访问数组元素
        int[] ages = {12, 24, 36};

        //取值
        System.out.println(ages[1]);

        //赋值
        ages[2] = 100;
        System.out.println(ages[2]);

        //访问数组长度
        System.out.println(ages.length);
    }
}
