package com.atguigu.fruit.dao.base;

import java.sql.*;

public  abstract class BaseDAO {
    public final String DRIVER = "com.mysql.jdbc.Driver";
    public final String URL="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false";
    public final String USER = "root";
    public final String PWD ="123456";
    protected ResultSet rs;
    protected Connection conn;
    protected PreparedStatement pstm;
    protected Connection getConn(){
        //加载驱动
        try {
            Class.forName(DRIVER);
            //通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL,USER,PWD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    protected void close(ResultSet rs, PreparedStatement pstm, Connection conn){

        try {
            if(rs!=null){
                rs.close();
            }
            if (pstm!=null) {
                pstm.close();
            }
            if (conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //执行更新，返回影响行数
    protected int executeUpdate(String sql,Object...params){

            try {
                conn = getConn();

                pstm = conn.prepareStatement(sql);
                if(params!=null && params.length>0){
                    for(int i = 0; i <params.length;i++){
                        pstm.setObject(i+1,params[i]);
                    }

                }
                return pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                close(rs,pstm,conn);
            }
            return 0 ;

    }
}
