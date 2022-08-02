package com.itheima.string;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args) {
        String okName = "itheima";
        String okPassword = "12345";
        int a = 12;

        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        if(a==b)
            System.out.println("em");//em
        System.out.println("登录名称：");

        String name = sc.next();
        System.out.println("登录密码：");
        String password = sc.next();

        if (okName.equals(name) && okPassword.equals(password)) {
                System.out.println("success");
        } else {
            System.out.println("error");
        }

    }
}
