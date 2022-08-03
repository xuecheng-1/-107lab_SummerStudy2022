package com.itheima.arraylist;

import java.util.ArrayList;

public class ArrayListDemo2 {
        //使用泛型定义集合较为规范
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
//        JDK1.7开始，泛型后面的数据类型申明可以不写
        list.add("Java");
//        list.add(123);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(123);
        list2.add(45);
//        list2.add("stty");
    }
}
