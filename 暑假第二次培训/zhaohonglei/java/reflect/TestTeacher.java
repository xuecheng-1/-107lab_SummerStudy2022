package com.itheima.reflect;

public class TestTeacher {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setName("²¨×Ð");
        t.setSalary(9000);
        t.setSex('Å®');
        MybatisUtil.save(t);
    }
}
