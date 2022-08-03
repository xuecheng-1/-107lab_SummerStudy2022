package com.itheima.create;

public class MethodDemo3 {
    public static void main(String[] args) {
    fire();
    fire("ss");
    fire("cs",1000);
    }
    public static  void fire(){
        System.out.println("发射！");
    }
    public static  void fire(String loc){
        System.out.println("发射到"+loc);
    }
    public static  void fire(String loc,int number){
        System.out.println("发射"+number+"到"+loc);
    }
}
