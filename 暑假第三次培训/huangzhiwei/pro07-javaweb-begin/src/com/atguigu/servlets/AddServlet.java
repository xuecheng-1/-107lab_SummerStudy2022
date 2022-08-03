package com.atguigu.servlets;


import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        //post方式下，设置编码，防止中文乱码
        //get方式目前不需要设置编码(基于tomcat8)
        reqest.setCharacterEncoding("UTF-8"); //放在第一行
        super.doPost(reqest, response);
        String fname = reqest.getParameter("fname");
        String priceStr = reqest.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = reqest.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = reqest.getParameter("remark");

        FruitDAO fruitDAO = new FruitDAOImpl();
       boolean flag =  fruitDAO.addFruit(new Fruit(0,fname,price,fcount,remark));
        System.out.println(flag?"添加成功":"添加失败");

    }
}
