package com.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class Test1 {

    //1.getConstructors:
    //获取全部的构造器，只能获取public修饰的构造器
    //Constructor[] getConStructors()
    @Test
    public void getConstructors() {
        //a.第一步：获取对象
        Class c = Student.class;
        //b.提取类中的【全部构造器对象】
        Constructor[] constructors = c.getConstructors();
        //c.遍历构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "==>" + constructor.getParameterCount());
        }

    }

    //2.getDeclaredConstructors():
    //获取[全部的构造器]：只要你敢写，这里都能拿到，无所谓权限
    @Test
    public void getDeclaredConstructors() {
        //a.第一步：获取对象
        Class c = Student.class;
        //b.提取类中的【全部构造器对象】
        Constructor[] constructors = c.getDeclaredConstructors();
        //c.遍历构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "==>" + constructor.getParameterCount());
        }

    }

    //3.getConStructor(Class ... parameterTypes)
    //获取某个构造器：只能拿public修饰的【某个构造器】
    @Test
    public void getConstructor() throws NoSuchMethodException {
        //a.第一步：获取对象
        Class c = Student.class;
        //b.定位【单个构造器对象】  （按照参数定位无参的构造器,只能拿public修饰的某个构造器）
        Constructor cons = c.getConstructor();
        //c.输出构造器
        System.out.println(cons.getName() + "==>" + cons.getParameterCount());

    }

    //4.getDeclaredConstructor
    //获取某个构造器：只要你敢写，就能拿到，无所谓权限
    @Test
    public void getDeclaredConstructor() throws NoSuchMethodException {
        //a.第一步：获取对象
        Class c = Student.class;
        //b.定位【单个构造器对象】  （按照参数定位无参的构造器）
        Constructor cons = c.getDeclaredConstructor();
        System.out.println(cons.getName() + "==>" + cons.getParameterCount());

        //c定位某个有参构造器
        Constructor cons1 = c.getDeclaredConstructor(String.class, String.class, String.class, int.class);
        System.out.println(cons1.getName() + "==>" + cons1.getParameterCount());

    }
}
