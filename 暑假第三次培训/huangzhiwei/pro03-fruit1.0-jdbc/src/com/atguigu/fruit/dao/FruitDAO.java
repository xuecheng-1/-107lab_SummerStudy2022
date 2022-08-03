package com.atguigu.fruit.dao;

import com.atguigu.fruit.pojo.Fruit;

import java.sql.SQLException;
import java.util.List;

public interface FruitDAO {
    //显示库存列表
    List<Fruit>getFruitList() throws SQLException;
    //新增库存
    boolean addFruit(Fruit fruit);
    //修改库存
    boolean updateFruit(Fruit fruit) throws SQLException;
    //根据名称查询特定水果
    Fruit getFruitByname(String fname);
    //库存下架
    boolean dekFruit(String fname);

}
