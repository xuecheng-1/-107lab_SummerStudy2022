package com.atguigu.fruit.dao.base;

import com.atguigu.fruit.pojo.Fruit;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  abstract class BaseDAO<T> {
    public final String DRIVER = "com.mysql.jdbc.Driver";
    public final String URL="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false";
    public final String USER = "root";
    public final String PWD ="123456";
    protected ResultSet rs;
    protected Connection conn;
    protected PreparedStatement pstm;
    protected Connection getConn(){
        //加载驱动
        try {
            Class.forName(DRIVER);
            //通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL,USER,PWD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //T的class对象
    private Class entityClass;
    public BaseDAO(){
        Type genericType = getClass().getGenericSuperclass();
        //ParameterizedType参数化类型
        Type[] actualTypeArguments =((ParameterizedType)genericType).getActualTypeArguments();
        //获取<T>中的真实类型
        Type actualType =actualTypeArguments[0];
        try {
            entityClass =  Class.forName(actualType.getTypeName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected void close(ResultSet rs, PreparedStatement pstm, Connection conn){

        try {
            if(rs!=null){
                rs.close();
            }
            if (pstm!=null) {
                pstm.close();
            }
            if (conn!=null&&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //执行更新，返回影响行数
    private void  setParmas(PreparedStatement pstm,Object...params) throws SQLException {
        if(params!=null && params.length>0){
            for(int i = 0; i <params.length;i++){
                pstm.setObject(i+1,params[i]);
            }

        }
    }
    protected int executeUpdate(String sql,Object...params) throws SQLException {

            try {
                conn = getConn();

                pstm = conn.prepareStatement(sql);
               setParmas(pstm,params);
                return pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                close(rs,pstm,conn);
            }
            return 0 ;

    }
    //通过反射技术给obj对象的property属性赋propertyValue值
    private void setValue(Object obj ,  String property , Object propertyValue){
        Class clazz = obj.getClass();
        try {
            //获取property这个字符串对应的属性名 ， 比如 "fid"  去找 obj对象中的 fid 属性
            Field field = clazz.getDeclaredField(property);
            if(field!=null){
                field.setAccessible(true);
                field.set(obj,propertyValue);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //执行查询，返回List
    protected List<T> executeQuery(String sql , Object... params){
        List<T> list = new ArrayList<>();
        try {
            conn = getConn() ;
            pstm = conn.prepareStatement(sql);
            setParmas(pstm,params);
            rs = pstm.executeQuery();

            //通过rs可以获取结果集的元数据
            //元数据：描述结果集数据的数据 , 简单讲，就是这个结果集有哪些列，什么类型等等

            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int columnCount = rsmd.getColumnCount();
            //6.解析rs
            while(rs.next()){
                T entity = (T)entityClass.newInstance();

                for(int i = 0 ; i<columnCount;i++){
                    String columnName = rsmd.getColumnName(i+1);            //fid   fname   price
                    Object columnValue = rs.getObject(i+1);     //33    苹果      5
                    setValue(entity,columnName,columnValue);
                }
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            close(rs,pstm,conn);
        }
        return list ;
    }
    //执行查询，返回单个实体对象
    protected  T load (String Sql,Object...params) {
        try {
            conn= getConn();

            //创建预处理命令对象
            pstm = conn.prepareStatement(Sql);
            setParmas(pstm,params);
            //执行查询
            rs = pstm.executeQuery();
            //通过rs可以获得结果值的元数据
            //元数据：描述结果集数据的数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int columCount = rsmd.getColumnCount();
            //解析结果集
            if (rs.next()){
                T entity = (T)entityClass.newInstance();
                for(int i = 0;i<columCount;i++){
                    String columnName = rsmd.getColumnName(i+1);  //fid fname
                    Object columnValue = rs.getObject(i+1); //3 苹果
                    setValue(entity,columnName,columnValue);
                }

             return entity;
            }
        } catch (InstantiationException | IllegalAccessException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs,pstm,conn);
        }
        return  null;
    }
}
