package com.atguigu.fruit.dao.impl;
import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.base.BaseDAO;
import com.atguigu.fruit.pojo.Fruit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class FruitDAOImpl extends BaseDAO implements FruitDAO {


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
        String sql= "insert into t_fruit values(null,?,?,?,?)";
        return super.executeUpdate(sql,fruit.getFname(),fruit.getPrice(),fruit.getFcount(),fruit.getRemark())>0;
    }
    @Override
    public boolean updateFruit(Fruit fruit) {
            String sql = "update t_fruit set fcount = ? where fid = ? " ;
            return super.executeUpdate(sql,fruit.getFcount(),fruit.getFid())>0;
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
        String sql = "delete from t_fruit where fname like ? " ;
        return super.executeUpdate(sql,fname)>0;
    }
}
