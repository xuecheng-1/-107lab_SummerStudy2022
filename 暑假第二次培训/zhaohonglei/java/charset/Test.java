package com.itheima.charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //1.编码：把文字转换为字节
        String name = "abc我爱你中国";
        //18个字节utf-8
        //byte[] bytes = name.getBytes();//以当前默认字符集（utf-8）进行编码
        //13个字节GBK
        byte[] bytes = name.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        //2.解码：把字节转换称为对应的中文形式（编码前后的字符集必须一致）
        //默认的UTF-8代码
        //String rs  =new String(bytes);
        //GBK解码
        String rs = new String(bytes,"GBK");
        System.out.println(rs);
    }
}
