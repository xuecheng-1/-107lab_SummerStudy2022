package com.ithenma.variable;

public class VariableDemo3 {
    public static void main(String[] args) {
        //1.byte 字节型 1个字节 -128~127
        byte number = 98;
        System.out.println(number);

        //2.short 短整型 2个字节
        short money = 30000;
        System.out.println(money);

        //3.int 4个字节

        //4.long 常整型 8 个字节
//        long lg = 13332442444;
//        注意：随便写一个整型数字默认为int
//        要加l/L
        long lg=123456789876534567l;

        //5.浮点型 4个字节
//        注意：随意写一个小数字面量默认double类型
//        要加f/F
        float score = 99.5F;


        //6.double 双精度 8个字节
        double score2 = 999.99;

        //7.字符型 char
        char ch1= 'a';
        //char ch2='中国'；报错

        //8.布尔类型 boolean
        boolean rs = true;
        boolean rs2 = false;

        System.out.println("---------引用数据类型----------");

        String name = "西门吹雪";
        System.out.println(name);


    }
}
