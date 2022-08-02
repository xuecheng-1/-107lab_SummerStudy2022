package com.itheima.demo;

import java.util.Scanner;

public class ShopCar {
    public static void main(String[] args) {
        Goods[] shopCar = new Goods[100];
        while (true) {
            System.out.println("操作:");
            Scanner sc = new Scanner(System.in);
            System.out.println("输入命令");
            String command = sc.next();
            switch (command) {
                case "add":
                    addGoods(shopCar,sc);
                    break;
                case "query":
                    queryGoods(shopCar);
                    break;
                case "update":
                    updateGoods(shopCar);
                    break;
                case "pay":
                    payGoods(shopCar);
                    break;
            }
        }
    }

    public static void payGoods(Goods[] shopCar) {
    }

    public static void updateGoods(Goods[] shopCar) {
    }

    public static void queryGoods(Goods[] shopCar) {
    }

    public static void addGoods(Goods[] shopCar,Scanner sc) {
        System.out.println("编号：");
        int id = sc.nextInt();
        System.out.println("名称：");
        String name = sc.next();
        System.out.println("数量：");
        int buyNumber = sc.nextInt();
        System.out.println("价格：");
        double price = sc.nextDouble();

        Goods g = new Goods();
        g.id = id;
        g.buyNumber = buyNumber;

    }
}
