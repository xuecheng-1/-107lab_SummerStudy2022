package com.itheima.create;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(creatCode(5));
    }
    public static String creatCode(int n){
        String code = "";
        Random r = new Random();
        for(int i = 0;i<n;i++){
            int type = r.nextInt(3);//0,1,2
            switch(type){
                case 0:
                    //大写字符
                    char ch = (char) (r.nextInt(26)+65);
                    code += ch;
                    break;
                case 1:
                    //小写字符
                    char ch1 = (char) (r.nextInt(26)+97);
                    code += ch1;
                    break;
                case 2:
                    //数字
                    code += r.nextInt(10);
                    break;
            }
        }
        return code;
    }
}
