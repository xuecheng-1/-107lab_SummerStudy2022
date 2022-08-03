package com.itheima.byte_stream;

import java.io.*;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        //1.创建一个文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("day-03/src/data02.txt");
        File f = new File("day-03/src/data02.txt");
//方法一
//        //2.定义一个字节数组与文件的大小一样大
//        //f.length()为long型，强制转换
//        byte[] buffer = new byte[(int) f.length()];
//        int len = is.read(buffer);
//        System.out.println("读取了多少字节："+len);
//        System.out.println("文件大小"+f.length());
//        System.out.println(new String(buffer));

        //方法二:
        byte[] buffer = is.readAllBytes();//读取全部数组
        System.out.println(new String(buffer));
    }
}
