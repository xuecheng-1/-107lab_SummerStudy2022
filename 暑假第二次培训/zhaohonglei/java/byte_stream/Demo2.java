package com.itheima.byte_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //1.创建一个文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("day-03/src/data02.txt");

//        //2.定义一个字节数组，用于读取字节数组
//        byte[] buffer = new byte[3];
//        int len = is.read(buffer);
//        System.out.println("读取了几个字节:"+len);
//        String rs = new String(buffer);
//        System.out.println(rs);
//
//        int len1 = is.read(buffer);
//        System.out.println("读取了几个字节:"+len1);
//        //buffer数组依次覆盖
//        //String rs1 = new String(buffer);
//        //从0开始读多少倒多少
//        String rs1 = new String(buffer,0,2);
//
//        System.out.println(rs1);
//
//        int len2 = is.read(buffer);
//        System.out.println("读取了几个字节:"+len2);
//        String rs2 = new String(buffer);
//        System.out.println(rs2);

        //改进循环，每次读一个字节数组
        //缺点：可能不可以正确读取中文字符
        byte[] buffer = new byte[3];
        int len4;//记录每次读取的字节数
        while((len4 = is.read(buffer))!=-1){
            //读多少倒多少
            System.out.print(new String(buffer,0,len4));
        }
    }
}
