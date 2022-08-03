package com.itheima.memory;

public class ArrayDemo1 {
    //1.类编译成 ArrayDemo1.class文件

    //2.main方法提取到【栈】中
    //在栈中存储变量 a 值：10
    // int[] arr =左边存储数组变量

    //3.【堆】中开辟空间
    // new对象，地址赋给arr变量


    public static void main(String[] args) {
        int a = 10;
        int[] arr = new int[]{11, 22, 33};

        System.out.println(arr);

        arr[0] = 44;
        arr[1] = 55;
        arr[2] = 66;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
