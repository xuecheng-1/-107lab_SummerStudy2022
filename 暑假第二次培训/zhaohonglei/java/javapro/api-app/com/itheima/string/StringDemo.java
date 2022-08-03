package com.itheima.string;

import java.util.Random;
//生成验证码
public class StringDemo {
    public static void main(String[] args) {
        //可能出现的字符
        String datas = "abcdefghijklmnopqrstuvwxyz0123456789";

        //循环五次，【生成】一个随机的索引，提取对应的字符连接起来

        String code = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(datas.length());
            char c = datas.charAt(index);
            code += c;
        }
        //输出
        System.out.println(code);
    }
}
