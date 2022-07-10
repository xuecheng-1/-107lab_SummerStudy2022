import java.util.Scanner;

public class demo02 {
    /*实现接收三个班级的各四名学员的成绩信息，然后计算每个班级学员平均分
    * 二重循环，外层循环控制班级数量，内层循环控制学员数量*/
    public static void main(String[] args) {
        int classNum = 3;
        int stuNum = 4;


        for (int i = 1; i <= classNum; i++) {
            double avg = 0;
            int sum = 0;
            for (int j = 0; j < stuNum; j++) {
                int score = new Scanner(System.in).nextInt();
                sum  = sum + score;

            }
            avg = sum/stuNum;
            System.out.println("第"+i+"个班的平均成绩为："+avg);
        }
    }
}
