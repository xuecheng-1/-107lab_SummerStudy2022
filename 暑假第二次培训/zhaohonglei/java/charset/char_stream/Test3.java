package com.itheima.charset.char_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test3 {
    public static void main(String[] args) throws IOException {
        //Writer fw = new FileWriter("day-03/src/out03.txt");
        Writer fw = new FileWriter("day-03/src/out03.txt",true);

        //a. public void write(int c):写一个字符出去
//        fw.write('我');
        fw.write(98);
        fw.write('a');
        fw.write("\r\n");
        //b. public void write(String c):写字符串
        fw.write("（づ￣3￣）づ╭❤～");
        fw.write("\r\n");

        //c. public void write(String c,int pos,int len)
        //字符串的一部分
        fw.write("abc还需要",0,3);
        fw.write("\r\n");

        //d. public void write(char[] buffer)
        char[] chars = "abc我爱你".toCharArray();
        fw.write(chars);
        fw.write("\r\n");

        //e. public void write(char[] buffer,int pos,int len)
        //字符数组的一部分

        fw.write(chars,3,3);
        fw.write("\r\n");

        fw.flush();//必须刷新数据才从内存进入磁盘

        //关闭通道，回收资源
        fw.close();//包含flush();

    }
}
