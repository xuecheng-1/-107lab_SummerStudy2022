package com.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class Test2 {
    //获取某个构造器：只要你敢写，就能拿到，无所谓权限
    @Test
    public void getDeclaredConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //a.第一步：获取对象
        Class c = Student.class;
        //b.定位【单个构造器对象】  （按照参数定位无参的构造器）
        Constructor cons = c.getDeclaredConstructor();
        System.out.println(cons.getName() + "==>" + cons.getParameterCount());

        //遇到私有构造器，可以暴力反射
        cons.setAccessible(true);//打开权限

        //构造对象
        Student s = (Student) cons.newInstance();
        System.out.println(s);

        //c.定位某个有参构造器
        Constructor cons1 = c.getDeclaredConstructor(String.class, String.class, String.class, int.class);
        System.out.println(cons1.getName() + "==>" + cons1.getParameterCount());

        cons1.setAccessible(true);

        Student s1 = (Student) cons1.newInstance("张三","法外狂徒","123",21);
        System.out.println(s1);
    }

}
