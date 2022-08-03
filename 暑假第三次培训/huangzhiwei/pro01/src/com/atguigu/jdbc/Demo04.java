package com.atguigu.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//jdbc修改和删除
public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");
        String sql = "delete from t_fruit where fid = ? " ;
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, 5) ;
        int count = psmt.executeUpdate();
        System.out.println(count>0?"yes":"no");
        psmt.close();
        conn.close();
    }

}
