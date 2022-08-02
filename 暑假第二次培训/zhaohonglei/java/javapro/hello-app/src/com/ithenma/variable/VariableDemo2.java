package com.ithenma.variable;

public class VariableDemo2 {
    public static void main(String[] args) {
        //目标：变量的注意事项
        int a = 23;
        System.out.println(a);

//        1.变量的有效范围从自定义开始到“}”截止
        // 一个范围内不能定义2个同名变量
        {
//                int a=100;
            int c = 200;
        }
        {
            int c = 100;
        }
//         2.变量定义时可以没有初始值，但使用时必须要给初始值

        int i1 = 0b0101;
        System.out.println(i1);
        int i2 = 0141;
        System.out.println(i2);
        int i3 = 0x61;
        System.out.println(i3);
    }
}
