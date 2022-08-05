package com.atguigu.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//演示req保存作用域（demo1和demo02）
@WebServlet("/demo01")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.向req保存作用域保存数据
        req.setAttribute("uname","lili");
        //2.客户端重定向
        //resp.sendRedirect("demo02");
        //3.服务器端转发
        req.getRequestDispatcher("demo02").forward(req,resp);
        //1和2是客户端向服务器端发送请求到组件demo01，组件demo01
        //响应给客户端，客户端再发送请求给demo02组件，再响应给客户端，两次响应获取不到值为null
        //2.1和3是客户端向服务器端发送请求到组件demo01，组件demo01
        //在服务器内部转到demo02组件，再由demo02组件响应给客户端，再由一次响应，只有一次响应


    }
}