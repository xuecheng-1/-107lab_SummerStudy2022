package com.itheima.transfer_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharSetTest0 {
    public static void main(String[] args) {
        try {
            //代码：UTF-8 文件:UTF-8
            //1.创建缓冲字符出师表输入流管道接通
            BufferedReader br = new BufferedReader(new FileReader("day-03/src/out03.txt"));

            //2、定义一个list集合存储每行内容
            List<String> data = new ArrayList<>();

            //3、定义循环，按照行读取文章
            String line;
            while ((line = br.readLine())!=null){
                data.add(line);
            }
            System.out.println(data);
            //4.排序
            Collections.sort(data);
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
