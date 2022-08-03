package com.itheima.scanner;
//1.导包(并不需要自己写，以后通过工具导入更方便)

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        //2.得到一个键盘扫描器对象
        Scanner sc = new Scanner(System.in);

        //3.调用sc对象的功能等待接收用户输入的数据

        System.out.println("输入年龄");
        int age = sc.nextInt();
        System.out.println("你年龄是"+age);

        System.out.println("名字");
        String name = sc.next();
        System.out.println("欢迎"+name);
    }
}
