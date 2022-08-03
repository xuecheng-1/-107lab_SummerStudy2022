package com.atguigu.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//jdbc查询所有某一个
public class Demo06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");
        String sql = "SELECT*FROM t_fruit where fid=?" ;
        PreparedStatement psmt = conn.prepareStatement(sql);
        //填充参数
        psmt.setInt(1,4);
        ResultSet rs = psmt.executeQuery();
        //解析结果集
//        List<Fruit>fruitList = new ArrayList<>();
        if(rs.next()){
            //getInt 因为这一列是int类型，所以用getInt
            int fid = rs.getInt(1);
            String fname = rs.getString(2);
            int price = rs.getInt(3);
            int fcount = rs.getInt(4);
            String remark = rs.getString(5);
            Fruit fruit = new Fruit(fid,fname,price,fcount,remark);
            System.out.println(fruit);

        }
        //7释放资源
        rs.close();
        psmt.close();
        conn.close();

    }

}
