package com.itheima.d1_file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //1.常见File对象
        //【路径写法】：
        //  1.\\转义字符\(反斜杠) 防止出现\n之类
        //  2.或者使用正斜杠D:/桌面/java20天学习/0.大纲.jpg
        //  3.系统分割符（适用于多操作系统）
        //  File f = new File("D:"+File.separator+"桌面"+);
        File f = new File("D:\\桌面\\java20天学习\\0.大纲.jpg");

        long size = f.length();//字节大小
        System.out.println(size);

        //2.File 创建对象，支持绝对路径，支持相对路径【重点】
        //绝对路径
        File f1 = new File("");
        //相对路径：一般定位模块中的文件,相对【工程】
        File f2 = new File("day-03/data03.txt");
        System.out.println(f2.exists());
        System.out.println(f2.length());

        //3.File 创建文件，可以是文件也可以是文件夹
        File f3 = new File("D:/Software");
        System.out.println(f3.exists());//判断这个路径是否存在
    }

}
