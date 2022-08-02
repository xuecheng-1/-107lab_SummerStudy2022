package com.itheima.arraylist;

import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        //1.创建对象
        ArrayList list = new ArrayList();

        //2.添加数据
        list.add("java");
        list.add("java");
        list.add("mysql");
        list.add(23);
        list.add(23.5);
        list.add('中');

        System.out.println(list);
//        优化了结果，变成数据
//        [java, java, mysql, 23, 23.5, 中]

        System.out.println(list.add('中'));
        //true
        //3.给指定索引位置插入元素
        list.add(1,"照明");
        System.out.println(list);
//        [java, 照明, java, mysql, 23, 23.5, 中]
    }
}
