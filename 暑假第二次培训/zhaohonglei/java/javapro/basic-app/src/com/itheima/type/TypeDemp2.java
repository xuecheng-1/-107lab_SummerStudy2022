package com.itheima.type;

public class TypeDemp2 {
    public static void main(String[] args) {
        //掌握表达式的自动类型转换的rules

        byte a =10;
        int b =20;
        double c = 1.0;
        double rs = a +b +c ;
        System.out.println(rs);
        //面试题
        byte i = 10;
        byte j = 20;
        int k = i+j;
        System.out.println(k);

    }
}
