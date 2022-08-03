package com.atguigu.jdbc;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
////JDBC - 修改和删除
//public class Demo03 {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Fruit fruit = new Fruit(3,"猕猴桃","猕猴桃是水果之王");
//
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
//        String sql = "update t_fruit set fname = ? , remark = ? where fid = ? " ;
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setString(1,fruit.getFname());
//        psmt.setString(2,fruit.getRemark());
//        psmt.setInt(3,fruit.getFid());
//
//        int count = psmt.executeUpdate();
//
//        System.out.println(count > 0 ? "修改成功！" : "修改失败！");
//
//        psmt.close();
//        conn.close();
//    }
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//jdbc修改和删除
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Fruit fruit =new Fruit(3,"桃子","justsoso");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");
        String sql = "update t_fruit set fname = ? , remark = ? where fid = ? " ;
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, fruit.getFname());
        psmt.setString(2, fruit.getRemark());
        psmt.setInt(3, fruit.getFid()) ;
        int count = psmt.executeUpdate();
        System.out.println(count>0?"yes":"no");
        psmt.close();
        conn.close();
    }

}
