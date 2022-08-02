package com.itheima.arraylist;

import java.util.ArrayList;

public class ArrayDemo4 {
    public static void main(String[] args) {
        //目标： 学习删除数组并遍历的正确方案
        //1、创建一个ArrayList集合存储一个班级学生的成绩
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(98);
        scores.add(97);
        scores.add(88);
        scores.add(68);
        scores.add(58);
        System.out.println(scores);

        //2.去除低于80的
//        for (int i = 0; i < scores.size(); i++) {
//            int score = scores.get(i);
//            if(score<80){
//                scores.remove(i);
//            }
//        }
//      存在跳位BUG

        //回退索引法
//        for (int i = 0; i < scores.size(); i++) {
//            int score = scores.get(i);
//            if (score < 80) {
//                scores.remove(i);
//                i--;
//            }
//        }

        //倒位索引法
        for (int i = scores.size() - 1; i >= 0; i--) {
            int score = scores.get(i);
            if (score < 80) {
                scores.remove(i);
            }
        }

        System.out.println(scores);
    }
}
