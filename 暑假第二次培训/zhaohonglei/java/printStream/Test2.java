package com.itheima.printStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("金色传说");
        System.out.println("hhjhhhh");//实际上调用了打印流

        //改变输出语句的位置（定义）
        PrintStream ps = new PrintStream("day-04/src/log.txt");
        System.setOut(ps);//将系统打印流改成自己的打印流
        System.out.println("金色传说S");
        System.out.println("hhjhhhhs");
        ps.close();
    }
}
