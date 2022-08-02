package com.itheima.arraylist;

import java.util.ArrayList;

public class ArrayListDemo4 {
    public static void main(String[] args) {
        //目标：ArrayList集合存储自定义类型的对象
        //1、定义电影类
        //2、创建三个电影对象
        Movie m1 = new Movie("《(*^_^*)》",9.7,"罗宾斯");
        Movie m2 = new Movie("《bydcn》",9,"罗宾斯1");
        Movie m3 = new Movie("《下班苏》",9.9,"罗宾斯2");
        //3、创建一个电影类型的ArrayLIst集合，存储三部电影对象
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        System.out.println(movies);
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println(m.getName());
            System.out.println(m.getScore());
            System.out.println(m.getActor());
            System.out.println("-------------");
        }
    }
}
