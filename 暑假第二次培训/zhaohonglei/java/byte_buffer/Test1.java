package com.itheima.byte_buffer;

import java.io.*;

public class Test1 {
    public static void main(String[] args) {
        try (
                //这里放资源对象，用完自动关闭，自动调用对象的close方法关闭资源
                InputStream is = new FileInputStream("day-03/src/data02.txt");

                //【【a.把原始的字节输入流包装成高级的缓冲字节输入流】】=========
                InputStream bis = new BufferedInputStream(is);

                OutputStream os = new FileOutputStream("day-03/src/out02.txt");
                //【【b.把原始的字节输出流包装成高级的缓冲字节输入流】】=========
                OutputStream bos = new BufferedOutputStream(os);
        ){
            //byte数组长度的1024（当然了，这个长度大小也可以自己定）是指从输出缓冲池
            // 里面一点点搬数据到目标文件中，不同之前的是直接从字节流通道把源文件的数
            // 据搬到目标文件，用缓冲池还是会快一点的
            byte[] buffer = new byte[1024];//1KB
            int len;//记录每次读取的字节数
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer,0,len);
            }
            System.out.println("复制完成");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
