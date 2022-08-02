package com.itheima.memory;

public class ArrayDemo2 {
    public static void main(String[] args) {
        int[] arr1 = {11,22,33};

        int[] arr2 = arr1;

        System.out.println(arr1);
        System.out.println(arr2);

        arr2[1] = 99;
        System.out.println(arr1[1]);//99
    }
}
