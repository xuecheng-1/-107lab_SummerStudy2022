package com.itheima.printStream;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //1.创建一个打印流对象

        //PrintStream ps = new PrintStream(new FileOutputStream("day-04/src/ps.txt"),true,"UTF-8");
        //PrintStream ps = new PrintStream(new FileOutputStream("day-04/src/ps.txt",true));
        //PrintStream ps = new PrintStream("day-04/src/ps.txt");
        PrintWriter ps = new PrintWriter("day-04/src/ps.txt");
        // 【打印功能与PrintStream无区别】

        //
        ps.println(97);
        ps.println('a');
        ps.println(32.3);
        ps.println(true);
        ps.println("nnd");

        ps.write("敢杀我的马！");
        ps.close();
    }
}
