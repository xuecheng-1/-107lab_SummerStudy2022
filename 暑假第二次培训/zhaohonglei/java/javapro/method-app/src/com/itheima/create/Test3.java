package com.itheima.create;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        int[] scores = new int[6];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请你输入第" + (i + 1) + "个分：");
            int score = sc.nextInt();
            scores[i] = score;
        }

        int max = scores[0], min = scores[0];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
            sum += scores[i];
        }

        double result = (sum - max - min) * 1.0 / (scores.length - 2);
        System.out.println(result);
    }
}
