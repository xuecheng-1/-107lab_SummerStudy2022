package com.itheima.charset.char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //目标：每次读一个字符
        //1、创建一个字符输入管道与源文件接通
        Reader fr = new FileReader("day-03/src/data02.txt");

        //2、读取一个字符返回，没有可读的就返回-1
//        int code = fr.read();
//        System.out.println((char)code);
//

        //3、循环读取字符
        int code;
        while ((code = fr.read())!=-1){
            System.out.print((char)code);
        }
        fr.close();
    }
}
