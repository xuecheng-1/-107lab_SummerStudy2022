package com.itheima.serializable;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //1.创建一个学生对象
        Student s = new Student("陈磊","chenlei","12345",21);

        //2.对象序列化：使用对象字节输出流【包装字节输出流管道】
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day-04/src/object.txt"));

        //3.直接调用序列化方法
        oos.writeObject(s);

        //4.释放资源
        oos.close();

    }
}
