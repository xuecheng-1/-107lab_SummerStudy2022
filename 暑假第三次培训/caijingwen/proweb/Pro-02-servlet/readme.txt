1.设置编码
  tomcat8之前，设置编码：
  1）get请求方式：
   //get方式目前不需要设置编码（基于tomcat8）
   如果是get请求发送的中文数据，转码稍微有点麻烦（tomcat8之前）
   String fname=req.getparameter("fname");
   1.将字符串打散成字节数组
   byte【】 bytes=fname.getbytes("ISO-8859-1");
   2.将字节数组按照设定的编码重新组装成字符串
   fname=new String（bytes，“utf-8”）；
   2）post请求方式：
    req.setCharacterEncoding("UTF-8");
    Tomcat8以后，设置编码，只需针对post方式
     req.setCharacterEncoding("UTF-8");
   注意：设置编码post这一句话必须放在所有的获取参数动作之前
2.servlet的继承关系
  1)继承关系
   javax.servlet.Servlet接口
      javax.servlet.Genericservlet抽象类
         javax.servlet.HttpServlet抽象子类
   2）相关方法
   javax.servlet.Servlet接口：
   void init(config)-初始化方法
   void service（request，response）-服务方法//发送请求时，都会调用这个service服务方法
   void destory（）-销毁方法

   javax.servlet.GenericServlet抽象类:
     void service(request,response)-任然是抽象的

   javax.servlet.http.HttpServlet 抽象子类:
     void service(request,response)-不是抽象的
24集
3.servlet的生命周期
1)生命周期：从出生到死亡的过程就是生命周期，对应service中的三个方法：init（），service（），destory（）
2）默认情况下：
第一次接受请求时，这个servlet会进行实例化（调用构造方法）。初始化（调用init）、然后服务（调用servlet（））
从第二次请求开始，每一次都是服务
当容器关闭时（即点击左边的红色正方形），其中的所有的servlet实例会被销毁，调用销毁方法
3）通过案例我们发现：
  servlet实例Tomcat只会创建一个，所有的请求都是这个实例去响应。
  默认情况下，第一次请求时，Tomcat才会去实例化，初始化，然后再服务，
  这样的好处是提高系统的启动速度，缺点是第一次请求时，耗时较长
  故：如果要提高系统的启动速度，当前默认情况就是这样；如果要提高响应速度，我们应该是设置servlet的初始化时机
4）servlet的初始化时机
   默认是第一次请求时，实例化，初始化
   我们可以通过<load-on-startup>来设置servlet启动的先后顺序，数字越小，启动越靠前，最小值0；
   在web，xml中对应的servlet的标签页中设置
5）servlet在容器中是：单例的，线程不安全的
  单例：所有的请求都是同一个实例去响应
  线程不安全：一个线程需要根据这个实例中的某个成员变量去做逻辑判断。但是在中间的某个时机，另一个线程改变了
  这个成员变量的值，从而导致第一个线程的执行路径发生了变化
  我们已经知道了servlet是线程不安全的，给我们的启发是：尽量不要再servlet中定义成员变量，如果不得不定义成员变量，那么不要去：1.不要去
  修改成员变量的值2.不要去根据成员变量的值做出一些逻辑判断
4.Http协议（最大的作用是确定了请求和响应数据的格式。
  1）Http称之为 超文本传输协议
  2）Http是无状态的
  3）Http请求响应包含两个部分：请求和响应
  请求包含三个部分：1.请求行；2.请求消息头；3.请求主体
  1）请求行包含三个信息：1.请求的方式；2.请求的URL；3.请求的协议（一般都是Http1.1）
  2）请求消息头中包含了很多客户端需要告诉服务器的信息，比如：我的浏览器型号、版本、我能接受的内容的类型、我给你发的内容的类型、内容的长度等等
  3）请求体，三种情况
  get方式，没有请求体，但有一个queryString
  post方式，有请求体，form data
  json格式，有请求体，request payload
  响应也包含三部分：1。响应行；2.响应头；3.响应体
  1）响应行包含三个信息：1.协议2.响应状态码；3.响应状态（OK）
  2）响应头：包含了服务器的信息；服务器方式给浏览器的信息（内容的媒体类型、编码、内容长度等）
  3）响应体：响应的实际内容（比如请求add.html页面时，响应的内容就是<html><head><body><form>...
5.会话
 1) Http是无状态:服务器无法判断两次请求是否是由同一个客户端发过来的
  通过会话跟踪技术来解决无状态的问题
 2)会话跟踪技术
 客户端第一次发请求给服务器，服务器获取session，获取不到，则创建新的，然后响应给客户端
 下次客户端给服务器发送请求时，会把sessionID带给服务器，那么服务器就能获取到了，那么服务器就能判断这一次请求和上次的某次请求是否是同一个客户端，从而能区分不同的客户端
   常用的API：
    req.getSession() ->获取当前的会话，没有则创建一个新的会话
    req.getSession(true)  ->效果和不带参数相同
    req.getSession(false) ->获取当前会话，没有则返回null，不会创建新的

    session.getID() ->获取sessionID
    session.isNew()->判断当前session是否是新的
    session.getMaxInactiveInterval()->session的非激活间隔时长，默认1800秒
    session.setMaxInactiveInterval()
    session.invalidate()->强制性让会话立即失效


    3）session保存作用域
    session保存作用域是和具体的某一个session对应的
    常用的API：
    void session.setAttribute(k,v)
    Object session.getAttribute(k)
    void removeAttribute(k)

6.服务器内部转发以及客户端定向
  1）服务器内部转发:req.getRequestDispatcher("demo07").forward(request,response);//仅发送一次请求
  -一次请求响应的过程，对于客户端而言，内部经过了多少次转发，客户端是不知道
  2)客户端定向:res.sendRedirect("demo07");//发送两次请求
  -两次请求响应的过程，客户端肯定知道请求URL有变化
  -地址栏有变化



7.Thymeleaf-视图模板技术
 1)添加thymeleaf的jar包
 2）在web.xml文件中添加配置
 3）新建一个Servlet类ViewBaseServlet
 4）使得我们的servlet继承viewBaseServlet
 5)根据逻辑视图名称得到物理视图名称
      //此处的视图名称是index
      //那么thymeleaf会将这个逻辑视图名称对应到 物理视图 上去
      //逻辑视图名称：index
      //物理视图名称：view-prefix + 逻辑视图名称 + view-suffix
      //所以真实的视图名称是   :    /   index    .html
      super.processTemplate("index",req,resp);
      6)使用themeleaf标签
      th:if;  th:unless;  th:each;  th:text;


//200正常响应
//302重定向
//404找不到资源
//405请求方式不支持
//500服务器内部错误
