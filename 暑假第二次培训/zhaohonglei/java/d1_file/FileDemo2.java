package com.itheima.d1_file;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo2 {
    public static void main(String[] args) {
        //1.绝对路径创建一个文件对象
        File f1 = new File("D:/桌面/java20天学习/0.大纲.jpg");
        //a.获取绝对路径
        System.out.println(f1.getAbsoluteFile());
        //b.获取文件定义时使用的路径
        System.out.println(f1.getPath());
        //c.获取文件的名称
        System.out.println(f1.getName());
        //d.获取文件的大小
        System.out.println(f1.length());
        //e.获取文件的最后修改时间
        long time = f1.lastModified();
        System.out.println("最后修改时间："+new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time));
        //f:判断是文件还是文件夹
        System.out.println(f1.isFile());//文件？
        System.out.println(f1.isDirectory());//文件夹？
    }
}
