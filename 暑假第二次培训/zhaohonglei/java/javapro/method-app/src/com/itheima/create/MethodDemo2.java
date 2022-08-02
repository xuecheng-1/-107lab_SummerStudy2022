package com.itheima.create;

public class MethodDemo2 {
    public static void main(String[] args) {
        int[] ages = {23, 19, 25, 78, 34};
        int max = getArrayMaxData(ages);
        System.out.println();
        System.out.println("最大值数据是：" + max);
    }

    public static int getArrayMaxData(int[] arr) {
        int max = arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
