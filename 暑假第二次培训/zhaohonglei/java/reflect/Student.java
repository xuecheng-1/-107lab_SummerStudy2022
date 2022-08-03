package com.itheima.reflect;

import java.io.Serializable;

/**
 * 对象要序列化，要实现Serializable接口
 */
public class Student implements Serializable {
    //申明序列化中的版本号码
    //序列化的版本号与反序列化的版本号一致才不会报错
    private static final long serialVersionUID = 1;
    public static final String NAME = "中国";
    private static String loginName;
    private transient String passWord;
    private int age;

    public Student() {
        System.out.println("无参构造器");
    }

    private Student( String loginName, String passWord, int age) {
        System.out.println("有参构造器");
        this.loginName = loginName;
        this.passWord = passWord;
        this.age = age;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "student{"+
                "name='" + NAME + '\''+
                ",loginName='" + loginName + '\''+
                ",passWord='" + passWord + '\''+
                ",age='" + age +
                '}';
    }
}
