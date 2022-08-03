package com.itheima.charset.char_stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //目标：每次读一个字符
        //1、创建一个字符输入管道与源文件接通
        Reader fr = new FileReader("day-03/src/data02.txt");

        //2、读取一个字符数组返回，没有可读的就返回-1
        char[] buffer = new char[1024];//1KB
        int len;
        while ((len = fr.read(buffer))!=-1){
            String rs = new String(buffer,0,len);
            System.out.print(rs);
        }
        fr.close();
    }
}
