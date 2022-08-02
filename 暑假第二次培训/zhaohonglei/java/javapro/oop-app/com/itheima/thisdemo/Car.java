package com.itheima.thisdemo;

public class Car {
    String name;
    double price;
    public Car(){
        System.out.println("无参数构造器中的this:"+this);
    }

    public void run(){
        System.out.println("方法中的this:"+this);
    }

    public Car(String name,double price){
        this.name = name;
        this.price = price;
    }
//age相关

    private int age;
    public void getAge(){
        System.out.println(age);
    }
    public void setAge(int age){
        if(age>=0&&age<=200){
            this.age = age;
        }
        else {
            System.out.println("error");
        }
    }
//
}
