package com.itheima.byte_stream;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        //1.创建一个文件字节输入流管道与源文件接通
        //InputStream is = new FileInputStream(new File("day-03/data.txt"));
        InputStream is = new FileInputStream("day-03/data.txt");
        InputStream is2 = new FileInputStream("day-03/data.txt");

        ///2.不断读取一个字节并返回
        int b1 = is.read();
        System.out.println((char)b1);

        int b2 = is.read();
        System.out.println((char)b2);

        int b3 = is2.read();
        System.out.println((char)b3);

        int b4 = is2.read();//读取完毕,返回字节-1
        System.out.println(b4);

        //3.循环改进
        //定义一个变量记录每次读取的字节
        //缺点：【中文字节无法正常读取】
        //     【性能慢】
//        int b;
//        //先把值给b,再判断返回字节
//        while ((b = is.read())!=-1){
//            System.out.println((char)b);
//        }
        is.close();
        is2.close();
    }
}
