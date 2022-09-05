1.404找不到对应的资源
2.若部署html页面时，出现404报错，则在Tomcat9.0.52中选择浏览文件夹路径，不要跳过每一级
3.web小蓝点操作在20集末尾
4.创建部署包-artifact
pro01 exploded 解压后的部署包
Pro01 Arei...未解压的部署包，放到Tomcat会自动解压
5.lib-artifact
  现有artifact，后来才添加的mysql.jar。此时，这个jar包并没有添加到部署包中，那么在project-structure中会有提示,我们点击fix选择add to..
  另外，我们也可以直接把lib文件夹直接新建在web-inf下。
  这样不好的地方是这个lib只能是这个当前moudle独享。如果有第二个moudle我们需要再次重复新建lib
6.在部署的时候，修改application Context。然后再回到server选项卡，检查URL的值。
  URL的值指的是Tomcat启动完成后自动打开你指定的浏览器，然后访问默认的网址。启动后包404意味着找不到指定的资源
  如果我们的网址是：http://localhost:8080/pro01/,那么表明我们访问的是index.html
  我们可以通过<welcome-file-list>标签进行设置欢迎页（在Tomcat的web.xml中设置，或者在自己的项目中设置）
7.405问题，当前请求的方法不支持。比如，我们表单method=post，那么servlet必须对应doPOST，否则报405错误，或者method没写，默认get
8.空指针或者是NumberFormatException。因为有价格和库存。如果价格取不到，结果你想对null进行Integer.parseInt()
  就会报错，错误原因大部分是因为name=“price”此处写错了，结果在servlet段还是使用req.getParameter("price")去获取。
  两处的price写的不一样，可能某处多了一空格
  shift+f6:重命名
  讲一个
  package com.atguigu.demo;

  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import java.io.IOException;

  @WebServlet("/demo01")
  public class DemoServlet01 extends HttpServlet {
      @Override
      protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //1.向req保存作用域保存数据
          req.setAttribute("uname","lili");
          //2.客户端重定向
          resp.sendRedirect("demo02");
      }
  }


  package com.atguigu.demo;

  import javax.servlet.ServletException;
  import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import java.io.IOException;

  @WebServlet("/demo02")
  public class DemoServlet02 extends HttpServlet {
      @Override
      protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Object unameObj= req.getAttribute("uname");
          System.out.println("unameObj="+unameObj);
      }
  }