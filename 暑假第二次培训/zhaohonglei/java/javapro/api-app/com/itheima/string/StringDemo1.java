package com.itheima.string;

public class StringDemo1 {
    public static void main(String[] args) {
//        方法一
        String name = "我爱你中国";
        System.out.println(name);
//        方法二
//        1.public  String();   几乎不用
        String s1 = new String();
//       等价于 s1 = " "

//        2.public  String(String);几乎不用
        String s2 = new String("我爱你中国");
        System.out.println(s2);

//        3.public  String(char[] b); 根据字符数组的内容，创建字符串对象
        char[] chars = {'a','b','c'};
        String s3 = new String(chars);
        System.out.println(s3);

//        4.public  String(byte[] b); 根据字节数组的内容，创建字符串对象
        byte[] bytes = {99,98,97,49};
        String s4 = new String(bytes);
        System.out.println(s4);

        //区别
        String ss1 = "abc";
        String ss2 = "abc";


    }
}
