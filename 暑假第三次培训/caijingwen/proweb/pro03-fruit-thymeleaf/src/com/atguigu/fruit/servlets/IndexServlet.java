package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       FruitDAO fruitDAO=new FruitDAOImpl();
       List<Fruit> fruitList=fruitDAO.getFruitList();
       //保存session的作用域
       HttpSession session=req.getSession();
       session.setAttribute("fruitList",fruitList);
       //此处的视图名称是index
        //那么thymeleaf会将这个逻辑视图名称对应到 物理视图 上去
        //逻辑视图名称：index
        //物理视图名称：view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是   :    /   index    .html
       super.processTemplate("index",req,resp);
    }
}
