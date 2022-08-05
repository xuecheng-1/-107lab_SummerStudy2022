package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.pojo.Fruit;


import java.util.List;

public class FruitDAOImpl extends com.atguigu.fruit.dao.base.BaseDAO<Fruit> implements FruitDAO{


    @Override
    public List<Fruit> getFruitList() {
        return executeQuery("select * from t_fruit");
    }

    @Override
    public Fruit getFruitByFid(int fid) {
        return null;
    }


}
