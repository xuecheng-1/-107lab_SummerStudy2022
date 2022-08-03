package com.itheima.transfer_stream;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //代码：UTF-8 文件 GBK(ANSI) 路径  D:/Test/gdkfile.txt
        //1.提取GDK文件原始字节流。
        InputStream is = new FileInputStream("D:/Test/gdkfile.txt");

        //2.原始字节流转换为字符
        //Reader isr = new InputStreamReader(is);//默认以UTF-8形式转换为字符流，会乱码
        Reader isr = new InputStreamReader(is,"GBK");//不会乱码

        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }

        br.close();
    }
}
