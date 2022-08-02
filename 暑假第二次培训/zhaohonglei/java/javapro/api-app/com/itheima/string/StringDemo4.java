package com.itheima.string;

import java.util.Scanner;

//手机号码屏蔽
public class StringDemo4 {
    public static void main(String[] args) {
        //1.录入手机号码
        Scanner sc = new Scanner(System.in);
        System.out.println("输入手机号");
        String tel = sc.next();

        //2.截取
        String before = tel.substring(0, 3);
        String after = tel.substring(7);

        String s = before + "****" + after;
        System.out.println(s);
    }
}
