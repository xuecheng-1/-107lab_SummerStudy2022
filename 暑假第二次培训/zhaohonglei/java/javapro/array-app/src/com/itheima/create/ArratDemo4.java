package com.itheima.create;

public class ArratDemo4 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 8};
//                   0 1 2 3

        for (int i = 0; i < arr.length - 1; i++) {
            //i == 1  比较3次  j = 0 1 2
            //i == 2  比较2次  j = 0 1
            //i == 3  比较1次  j = 0
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //快捷键：arr.fori
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
