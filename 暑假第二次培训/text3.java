public class Dog {
    String breed;
    int size;
    String colour;
    int age;
 
    void eat() {
    }
 
    void run() {
    }
 
    void sleep(){
    }
 
    void name(){
    }
}

public class Puppy {
   public Puppy() {
   }

   public Puppy(String name) {
      // 这个构造器仅有一个参数：name
   }
}

public class Puppy{
    public Puppy(String name){
       //这个构造器仅有一个参数：name
       System.out.println("小狗的名字是 : " + name ); 
    }
    public static void main(String[] args){
       // 下面的语句将创建一个Puppy对象
       Puppy myPuppy = new Puppy( "tommy" );
    }
 }
 /* 实例化对象 */
Object referenceVariable = new Constructor();
/* 访问类中的变量 */
referenceVariable.variableName;
/* 访问类中的方法 */
referenceVariable.methodName();
public class Puppy{
    int puppyAge;
    public Puppy(String name){
       // 这个构造器仅有一个参数：name
       System.out.println("小狗的名字是 : " + name ); 
    }
  
    public void setAge( int age ){
        puppyAge = age;
    }
  
    public int getAge( ){
        System.out.println("小狗的年龄为 : " + puppyAge ); 
        return puppyAge;
    }
  
    public static void main(String[] args){
       /* 创建对象 */
       Puppy myPuppy = new Puppy( "tommy" );
       /* 通过方法来设定age */
       myPuppy.setAge( 2 );
       /* 调用另一个方法获取age */
       myPuppy.getAge( );
       /*你也可以像下面这样访问成员变量 */
       System.out.println("变量值 : " + myPuppy.puppyAge ); 
    }
 }

import java.io.*;

public class Employee{
   String name;
   int age;
   String designation;
   double salary;
   // Employee 类的构造器
   public Employee(String name){
      this.name = name;
   }
   // 设置age的值
   public void empAge(int empAge){
      age =  empAge;
   }
   /* 设置designation的值*/
   public void empDesignation(String empDesig){
      designation = empDesig;
   }
   /* 设置salary的值*/
   public void empSalary(double empSalary){
      salary = empSalary;
   }
   /* 打印信息 */
   public void printEmployee(){
      System.out.println("名字:"+ name );
      System.out.println("年龄:" + age );
      System.out.println("职位:" + designation );
      System.out.println("薪水:" + salary);
   }
}
import java.io.*;

public class EmployeeTest {

   public static void main(String[] args) {
      /* 使用构造器创建两个对象 */
      Employee empOne = new Employee("RUNOOB1");
      Employee empTwo = new Employee("RUNOOB2");

      // 调用这两个对象的成员方法
      empOne.empAge(26);
      empOne.empDesignation("高级程序员");
      empOne.empSalary(1000);
      empOne.printEmployee();

      empTwo.empAge(21);
      empTwo.empDesignation("菜鸟程序员");
      empTwo.empSalary(500);
      empTwo.printEmployee();
   }
}