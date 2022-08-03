package com.itheima.arraylist;

import java.util.ArrayList;

public class ArrayListDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("HTML");
        list.add("Java");
        list.add("MySQL");
        list.add("MyBatis");
        list.add("HTML");

        //1.public E get(int index);获取某个索引位置的元素
        String e = list.get(3);
        System.out.println(e);

        //2.public int size():获取集合的大小
        System.out.println(list.size());

        //3.遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //4.public E remove(int index);删除某个索引位置的元素，返回此元素
        System.out.println(list);
        String e2 = list.remove(2);
        System.out.println(e2);
        System.out.println(list);

        //5.public boolean remove(Object o);删除某个索引位置的元素
        System.out.println(list.remove("MyBatis"));
        System.out.println(list);

        list.remove("Java");
        System.out.println(list);

        //6.public E set(int index,E element);修改某个索引位置的元素
        String e3 = list.set(1,"CSS");
        System.out.println(e3);
        System.out.println(list);


    }
}
