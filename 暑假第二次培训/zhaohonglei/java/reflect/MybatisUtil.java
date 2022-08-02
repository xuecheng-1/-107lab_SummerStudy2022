package com.itheima.reflect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {
    /**
     * 保存任意类型的对象
     */
    public static void save(Object obj) {

        try (
                PrintStream ps = new PrintStream(new FileOutputStream("day-05/src/data.txt", true));
        ) {

            //1.提供这个对象的全部成员变量：只有反射可以解决
            // obj.getSimpleName()获取当前类名
            // obj.getClass()     获取包名 + 类名
            Class c = obj.getClass();

            ps.println("===============" + c.getSimpleName() + "==========");

            //2.提取他的全部成员变量
            Field[] fields = c.getDeclaredFields();
            //3.获取成员变量的信息
            for (Field field : fields) {
                String name = field.getName();
                //提取本成员变量在obj对象中的值（取值）;

                field.setAccessible(true);
                //强转String在此时不可取比如double
                String value = field.get(obj) + "";
                ps.println(name + "=" + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
