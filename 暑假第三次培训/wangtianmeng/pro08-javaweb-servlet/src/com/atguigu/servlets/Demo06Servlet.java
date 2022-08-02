package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo06Servlet extends HttpServlet {
//演示服务器内部转发以及客户端重定向
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo06......");
        //服务器内部转发
        //request.getRequestDispatcher("demo07").forward(request,response);
        response.sendRedirect("demo07......");
    }
}
