package com.atguigu.jdbc;

import java.sql.*;

//jdbc查询总个数
public class Demo07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");
        String sql = "SELECT COUNT(*) FROM t_fruit" ;
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        //解析结果集
//        List<Fruit>fruitList = new ArrayList<>();
        if(rs.next()){
            int count = rs.getInt(1);
            System.out.println(count);

        }
        //7释放资源
        rs.close();
        psmt.close();
        conn.close();

    }

}
