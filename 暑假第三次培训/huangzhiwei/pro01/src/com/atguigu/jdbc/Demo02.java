package com.atguigu.jdbc;

import java.sql.*;


public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");
        //编辑SQL语句
        String sql ="insert into t_fruit values(null,?,?,?,?)";
        //创建预处理命令对象
        PreparedStatement psmt =conn.prepareStatement(sql);
        //填充参数
        psmt.setString(1,"榴莲");
        psmt.setInt(2,100);
        psmt.setInt(3,3000);
        psmt.setString(4,"火锅好吃");
        //执行更新，返回影响行数
        int count = psmt.executeUpdate();
        System.out.println(count>0?"chenggong":"shibai");
        //释放资源(关闭连接)
        psmt.close();
        conn.close();

    }
}
