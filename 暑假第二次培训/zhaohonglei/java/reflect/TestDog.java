package com.itheima.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestDog {
    /*
    获取类中的所有成员方法对象
     */
    @Test
    public void getDeclaredMethods(){
        //a.获取类对象
        Class c = Dog.class;
        //b.获取全部方法：包括私有的
        Method[] methods = c.getDeclaredMethods();

        //c.遍历全部方法
        for (Method method : methods) {
            System.out.println(method.getName() + "返回值类型："+ method.getReturnType() + "返回值参数个数：" + method.getParameterCount());
        }
    }
    //getName返回值类型：class java.lang.String返回值参数：0
    //run返回值类型：void返回值参数：0
    //setName返回值类型：void返回值参数：1
    //eat返回值类型：void返回值参数：0
    //eat返回值类型：class java.lang.String返回值参数：1
    //inAddr返回值类型：void返回值参数：0

    /**
     * 2.获取单个方法对象
     */
    @Test
    public void getDeclaredMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //a.获取类对象
        Class c = Dog.class;
        //b.提取单个方法对象
        Method m = c.getDeclaredMethod("eat");//无参
        Method m2 = c.getDeclaredMethod("eat",String.class);

        //暴力打开权限
        m.setAccessible(true);
        m2.setAccessible(true);

        //c.触发方法的执行
        Dog d = new Dog();
        //方法无结果返回null
        Object result = m.invoke(d);
        System.out.println(result);

        Object result2 = m2.invoke(d,"骨头");
        System.out.println(result2);
        //eat meat
        //null
        //dog eat骨头
        //dog eat it happily
    }
}
