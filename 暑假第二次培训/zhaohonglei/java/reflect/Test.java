package com.itheima.reflect;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class类中的一个静态方法：forName(全限定名：包名+类名)
        Class c = Class.forName("com.itheima.reflect.Student");
        System.out.println(c);

        //2.类名.class
        Class c1 = Student.class;
        System.out.println(c1);

        //3.对象.getClass()
//        Student s = new Student();
//        Class c2 = s.getClass();
//        System.out.println(c2);

    }
}
