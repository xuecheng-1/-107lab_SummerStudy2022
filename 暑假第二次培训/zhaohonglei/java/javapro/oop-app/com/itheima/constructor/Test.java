package com.itheima.constructor;

public class Test {
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.name);

        Car c2 = new Car("奔驰",39.8);
        System.out.println(c2.name);
        System.out.println(c2.price);
    }
}
