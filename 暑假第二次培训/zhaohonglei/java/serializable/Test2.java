package com.itheima.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.创建对象字节输入流管道包装低级的字节输入流管道
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("day-04/src/object.txt"));

        //2.调用对象字节输入流的反序列化方法
        Student s = (Student)is.readObject();

        System.out.println(s);

        //3.关闭流
        is.close();
    }
}
