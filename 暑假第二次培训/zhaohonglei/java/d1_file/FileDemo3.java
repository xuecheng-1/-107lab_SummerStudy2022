package com.itheima.d1_file;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        File f = new File("day-03\\src\\test.txt");
        //a,创建新文件，创建成功后返回true,反之，不需要这个，以后文件写出去后都会自动创建
        System.out.println(f.createNewFile());
        System.out.println(f.exists());
        File f1 = new File("day-03\\src\\test02.txt");
        System.out.println(f1.exists());
//
//        //b.mkdir创建一级目录
//        File f2 = new File("D:/Test/aaa");
//        System.out.println(f2.mkdir());
//
//        //c.mkdirs创建多级目录
//        File f3 = new File("D:/Test/aaa/bbb/ccc");
//        System.out.println(f3.mkdirs());
//
//        //d.删除文件或空文件夹
//        System.out.println(f1.delete());
//        File f4 = new File("day-03\\src\\test.txt");
//        System.out.println(f4.delete());//占用也可以删除
//
//        //只能删除空文件夹，不能删除非空文件夹
//        File f5 = new File("D:/Test/aaa");
//        System.out.println(f5.delete());
    }
}
