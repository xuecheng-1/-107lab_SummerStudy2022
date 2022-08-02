package com.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

public class Test3 {
    /*
    1.获取全部的成员变量
    Field[] getDeclaredFields();
    获得所有的成员变量相应的Field对象，只要申明了就可以拿到
     */
    @Test
    public void getDeclaredFields(){
        //a.定位Class对象
        Class c = Student.class;
        //b.定位全部成员变量
        Field[] fields = c.getDeclaredFields();
        //c.遍历一下
        for (Field field : fields) {
            System.out.println(field.getName() + "==>"+field.getType());
        }
    }

    @Test
    public void getDeclaredField() throws NoSuchFieldException, IllegalAccessException {
        //a.定位Class对象
        Class c = Student.class;
        //b.根据名称定位某个成员变量
        Field f = c.getDeclaredField("age");
        System.out.println(f.getName()+ "==>" + f.getType());

        f.setAccessible(true);

        //c.赋值
        Student s = new Student();
        f.set(s,18);//s.setAge(18);
        System.out.println(s);

        //d.取值
        int age = (int)f.get(s);

        System.out.println(age);
    }
}
