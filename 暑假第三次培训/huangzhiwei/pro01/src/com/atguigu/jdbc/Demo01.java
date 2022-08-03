package com.atguigu.jdbc;

import java.sql.*;
//目标：与数据库建立连接
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.添加jar包
        //2.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.通过驱动管理器获取连接对象
        //3-1准备url user pwd
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false";
        String user = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,user,pwd);
        System.out.println("conn="+conn);


    }
}

