package com.itheima.operator;

public class OperatorDemo2 {
    public static void main(String[] args) {
        int a=5;
        System.out.println("abc"+'a');//abca
        System.out.println("abc"+a);  //abc5
        System.out.println(5+a);      //10
        System.out.println("abc"+5+'a');//abc5a

        System.out.println(a+'a');//102
        System.out.println(a+""+'a');//5a
        System.out.println(a+'a'+"itheima");//102itheima
        System.out.println("itheima"+a+'a');//itheima5a
        System.out.println("itheima"+(a+'a'));//itheima102
    }

}
