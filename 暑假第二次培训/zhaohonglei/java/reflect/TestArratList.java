package com.itheima.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestArratList {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //需求：反射实现泛型擦除后，加入其他类型的元素
        ArrayList<String> lists = new ArrayList<>();
        ArrayList<Integer> lists2 = new ArrayList<>();

        //对象.getClass()文件
        System.out.println(lists.getClass());
        System.out.println(lists2.getClass());

        System.out.println(lists2.getClass() == lists.getClass());
        //class java.util.ArrayList
        //class java.util.ArrayList
        //true

        System.out.println("------------------");
        //public boolean  add(E e);
        lists2.add(23);
        lists2.add(22);
        //lists2.add("chao");报错

        Class c = lists2.getClass();
        //定位c类中的add方法
        Method add = c.getDeclaredMethod("add",Object.class);

        boolean rs = (boolean) add.invoke(lists2,"黑马");
        System.out.println(rs);
        System.out.println(lists2);
        //true
        //[23, 22, 黑马]
    }
}
