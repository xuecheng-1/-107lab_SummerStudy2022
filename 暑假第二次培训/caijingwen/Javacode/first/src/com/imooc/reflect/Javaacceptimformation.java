package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Javaacceptimformation {
    public static void main(String[] args) {
        //基本的数据类型都存在类类型
        Class c1=int.class;//int 的类类型
        Class c2=String.class;//String类的类类型 String类字节码
        Class c3=double.class;
        Class c4=Double.class;
        Class c5=void.class;
        System.out.println(c1.getName());
        System.out.println(c2.getName());//打印类的全称
        System.out.println(c2.getSimpleName());//不包含包名的类的名称
        System.out.println(c3.getName());
        System.out.println(c4.getName());
        System.out.println(c5.getName());
        System.out.println(int.class.getName());
        String s="hello";
        Javaacceptimformation ja=new Javaacceptimformation();
        ja.printClassmessage(s);
        Integer n1=1;
        ja.printClassmessage(n1);
        ja.printConMessage("hello");
        ja.printConMessage(new Integer(1));
        //要获取print（int，int）方法1.要获取一个方法就是获取类的信息，获取类的信息首先要获取一个类的类类型
        A a1=new A();
        Class c=a1.getClass();
        //2.获取方法名称和参数列表来决定
        try{
            Method m= c.getMethod("print",new Class[]{int.class,int.class});
            //Method m=c.getMethod("print",int.class,int.class);
            //方法的反射操作
            //方法的反射操作是用m对象来进行方法调用，和a1.print（10,20）调用的效果相同
          Object o=m.invoke(a1,new Object[]{10,20});
            System.out.println("=============================");
            Method m1=c.getMethod("print",String.class,String.class);
           o=m1.invoke(a1,"hello","world");
            System.out.println("==============");
            Method m2=c.getMethod("print");
            //Method m2=c.getMethod("print",new Class[]{});
            o=m2.invoke(a1);
            //o=m2.invoke(a1,new Object[]{});

        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public static  void printClassmessage(Object obj){
        //要获取类的信息，首先要获取类的类类型
        Class c=obj.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        //获取类的名称
        System.out.println("类的名称是："+c.getName());
        /*
        * Method类，方法对象
        * 一个成员就是一个Method对象
        * getMethods（）方法获取的是所有的public的函数，包括父类继承而来的
        * getDeclaredMethods（）获取的是所有该类自己声明的方法，不问访问权限
        */
        Method[] ms=c.getMethods();
       // c.getDeclaredMethods();
        for(int i=0;i<ms.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType=ms[i].getReturnType();
            System.out.println(returnType.getName()+" ");
            //得到方法的名称
            System.out.println(ms[i].getName()+"(");
            //获取参数类型  得到的是参数列表的类型的类类型
            Class[] paramTypes=ms[i].getParameterTypes();
            for(Class class1:paramTypes){
                System.out.println(class1.getName()+",");
            }
            System.out.println(")");
            /*
            成员变量也是对象
            java.lang.reflect.Field
            Field类封装了关于成员变量的操作
            getFields（）方法获取的是所有的public的成员变量信息
            getDeclaredField获取的是该类自己声明的成员变量的信息
            */
            Field[] fs =c.getDeclaredFields();
            for(Field field:fs){
                Class fieldType=field.getType();
                String typeName=fieldType.getName();
                String fieldName=field.getName();
                System.out.println(typeName+" "+fieldName);
            }
        }
   }
//打印对象的构造函数的信息

    public static void printConMessage(Object obj){
        Class c=obj.getClass();
        /*构造函数也是对象
        java.lang.Constructor中分装了构造函数的信息
        getConstructors获取所有的public的构造函数
        getDeclaredConstructors得到所有的构造函数
        * */
        //Constructor[] cs=c.getConstructors();
        Constructor[] cs=c.getDeclaredConstructors();
        for(Constructor constructor:cs){
            System.out.println(constructor.getName()+"(");
            Class[] paramTypes=constructor.getParameterTypes();
            for(Class class1:paramTypes){
                System.out.print(class1.getName()+",");
            }
            System.out.println();
        }
    }
    //
}
class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a,String b){
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
    }
    public  void print(){
        System.out.println("hello world");
    }
}
