package com.atguigu.jdbc;

import java.sql.*;


public class Demo01Batch {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //批处理操作1：如果要执行批处理任务，url需要添加一个参数:rewriteBatchedStatements=true
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false&rewriteBatchedStatements=true","root","123456");
        //编辑SQL语句
        String sql ="insert into t_fruit values(null,?,?,?,?)";
        //创建预处理命令对象
        PreparedStatement psmt =conn.prepareStatement(sql);
        //填充参数
        for(int i = 0;i<10;i++){
            psmt.setString(1,"榴莲");
            psmt.setInt(2,100);
            psmt.setInt(3,3000);
            psmt.setString(4,"火锅好吃");
            //批处理操作2：psmt.addBatch
            psmt.addBatch();
            //如果要执行1000000次，可以每1000次执行一次
//            if(i%1000==0){
//                psmt.executeBatch();
            //清空任务列表
//                psmt.clearBatch();
//            }
        }

        //批处理操作3：
        int[] count = psmt.executeBatch();
        for (int j : count) {
            System.out.println(j);
        }

        //释放资源(关闭连接)
        psmt.close();
        conn.close();

    }
}
