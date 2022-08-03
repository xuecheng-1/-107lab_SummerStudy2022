package com.itheima.serializable;

import java.io.Serializable;

/**
 * 对象要序列化，要实现Serializable接口
 */
public class Student implements Serializable {
    //申明序列化中的版本号码
    //序列化的版本号与反序列化的版本号一致才不会报错
    private static final long serialVersionUID = 1;
    private String name;
    private String loginName;
    private transient String passWord;
    private int age;

    public Student() {
    }

    public Student(String name, String loginName, String passWord, int age) {
        this.name = name;
        this.loginName = loginName;
        this.passWord = passWord;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
                "name='" + name + '\''+
                ",loginName='" + loginName + '\''+
                ",passWord='" + passWord + '\''+
                ",age='" + age +
                '}';
    }
}
