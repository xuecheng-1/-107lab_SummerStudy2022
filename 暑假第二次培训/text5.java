int a,b,c; // 声明三个int型整数：a、 b、c
int d=3,e=4,f=5; // 声明三个整数并赋予初值
byte z=22; // 声明并初始化 z
String s="runoob"; // 声明并初始化字符串 s
double pi=3.14159; // 声明了双精度浮点型变量 pi
char x='x'; // 声明变量 x 的值是字符 'x'。

public class Variable {
   static int allClicks = 0; // 类变量

   String str = "hello world"; // 实例变量

   public void method() {

      int i = 0; // 局部变量

   }
}

public class Test {
   public void pupAge() {
      int age = 0;
      age = age + 7;
      System.out.println("小狗的年龄是: " + age);
   }

   public static void main(String[] args) {
      Test test = new Test();
      test.pupAge();
   }
}

public class Test {
   public void pupAge() {
      int age;
      age = age + 7;
      System.out.println("小狗的年龄是 : " + age);
   }

   public static void main(String[] args) {
      Test test = new Test();
      test.pupAge();
   }
}

import java.io.*;

public class Employee{
   // 这个实例变量对子类可见
   public String name;
   // 私有变量，仅在该类可见
   private double salary;
   //在构造器中对name赋值
   public Employee (String empName){
      name = empName;
   }
   //设定salary的值
   public void setSalary(double empSal){
      salary = empSal;
   }  
   // 打印信息
   public void printEmp(){
      System.out.println("名字 : " + name );
      System.out.println("薪水 : " + salary);
   }
 
   public static void main(String[] args){
      Employee empOne = new Employee("RUNOOB");
      empOne.setSalary(1000.0);
      empOne.printEmp();
   }
}
import java.io.*;

public class Employee {
   // salary是静态的私有变量
   private static double salary;
   // DEPARTMENT是一个常量
   public static final String DEPARTMENT = "开发人员";

   public static void main(String[] args) {
      salary = 10000;
      System.out.println(DEPARTMENT + "平均工资:" + salary);
   }
}