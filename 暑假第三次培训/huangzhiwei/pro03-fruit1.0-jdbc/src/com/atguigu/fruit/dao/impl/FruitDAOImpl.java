package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FruitDAOImpl implements FruitDAO {
    ResultSet rs;
    Connection conn;
    PreparedStatement pstm;
    private Connection getConn(){
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理器获取连接对象
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void close(ResultSet rs,PreparedStatement pstm,Connection conn){

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
    @Override
    public List<Fruit> getFruitList() throws SQLException {
        List<Fruit>fruitList = new ArrayList<>();
        try {
            conn= getConn();
           //编写sql语句
            String sql = "select*from t_fruit";
            //创建预处理命令对象
            pstm = conn.prepareStatement(sql);
            //执行查询
            rs = pstm.executeQuery();
            //解析结果集
            while (rs.next()){
                int fid = rs.getInt(1);
                String fname = rs.getString(2);
                int price = rs.getInt(3);
                int fcount = rs.getInt(4);
                String remark = rs.getString(5);
                Fruit fruit = new Fruit(fid,fname,price,fcount,remark);
                fruitList.add(fruit);

            }
        } finally {
            close(rs,pstm,conn);
        }
        return fruitList;
    }

    @Override
    public boolean addFruit(Fruit fruit) {
        try {
            conn= getConn(); String sql= "insert into t_fruit values(null,?,?,?,?)";
            pstm =conn.prepareStatement(sql);
            //填充参数
            pstm.setString(1, fruit.getFname());
            pstm.setInt(2,fruit.getPrice());
            pstm.setInt(3,fruit.getFcount());
            pstm.setString(4,fruit.getRemark());
            return pstm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs,pstm,conn);
            }

    }

    @Override
//    public boolean updateFruit(Fruit fruit) throws SQLException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false","root","123456");
//            String sql = "update t_fruit set fcount where fid = ? ";
//            pstm = conn.prepareStatement(sql);
//            pstm.setInt(1,fruit.getFcount());
//            pstm.setInt(2,fruit.getFid());
//            return pstm.executeUpdate()>0;
//
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }finally {
//
//            try {
//                if (pstm!=null) {
//                    pstm.close();
//                }
//                if (conn!=null&&!conn.isClosed()){
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
    public boolean updateFruit(Fruit fruit) {

        try {

           conn = getConn();
           String sql = "update t_fruit set fcount = ? where fid = ? " ;
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,fruit.getFcount());
            pstm.setInt(2,fruit.getFid());
            return pstm.executeUpdate() > 0  ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,pstm,conn);
        }


        return false;
    }


    @Override
    public Fruit getFruitByname(String fname) {
        try {

            conn = getConn();
            String sql = "SELECT*FROM t_fruit where fname=?" ;
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,fname);
            rs = pstm.executeQuery();
            if(rs.next()){
                int fid = rs.getInt(1);
                int price = rs.getInt(3);
                int fcount = rs.getInt(4);
                String remark = rs.getString(5);
                return new Fruit(fid,fname,price,fcount,remark);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs,pstm,conn);
        }
        return null;
    }

    @Override
    public boolean dekFruit(String fname) {
        try {
            conn = getConn();
            String sql = "delete from t_fruit where fname like ? " ;
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,fname);
            return pstm.executeUpdate() > 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs,pstm,conn);
        }
        return false;

    }
}
