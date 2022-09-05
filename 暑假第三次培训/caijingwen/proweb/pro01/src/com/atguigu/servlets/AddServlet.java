package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");//必须放在获取参数之前
       //post 方式下设置编码，防止中文乱码，以上一条语句，在23集的9分左右
        //get方式目前不需要设置编码（基于tomcat8）
        String fname= req.getParameter("fname");
        String pricestr=req.getParameter("price");//用http方法传过来的参数只能是字符串
        Integer price=Integer.parseInt(pricestr);//把字符串强转成int类型
        String foountstr=req.getParameter("foount");
        Integer foount=Integer.parseInt(foountstr);
        String remark=req.getParameter("remark");
        System.out.println("fname="+fname);
        System.out.println("price="+price);
        System.out.println("foount="+foount);
        System.out.println("remark="+remark);
    }
}
