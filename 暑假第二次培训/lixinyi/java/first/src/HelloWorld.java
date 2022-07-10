import com.sun.javaws.IconUtil;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HelloWorld {
/*    public static void main(String[] args) {
        System.out.println("Hello World");
    }*/
    /*
    * 为成绩进行加分，直到分数大于等于九十为止
    * 输出加分前的成绩和加分后的成绩，并统计加分次数
    */


    public static void main(String[] args) {
        int score = new Scanner(System.in).nextInt();//初始分数
        int count = 0;//加分次数
        System.out.println("初始成绩："+score);
        while (score<60){
            score++;
            count++;

        }
        System.out.println("加分后的成绩："+score);
        System.out.println("加分次数为："+count);
    }






}
