package com.itheima.d1_file;

import java.io.File;

public class FileDemo5 {
    public static void main(String[] args) {
        //2、传入目录  和 文件名称
        searchFile(new File("D:/"),"a.txt");

    }

    /*
    搜索某个目录下的全部文件，找到我们想要的文体
     */
    public static void searchFile(File dir,String fileName){
        if(dir!=null&&dir.isDirectory()){
            //开始找吧
            //4.提取当前目录下的一级文件对象
            File[] files = dir.listFiles();//null{}
            //5.是否存在一级文件对象，存在才可以遍历
            if(files != null && files.length>0){
                for (File file : files) {
                    //6.判断当前遍历的一级文件对象是文件 还是 目录
                   if(file.isFile()){
                       //7.检查路径
                       if(file.getName().contains(fileName)){
                           System.out.println("找到了："+file.getAbsolutePath());
                       }
                   }else {
                       //8.是文件夹，继续递归
                       searchFile(file,fileName);
                   }
                }
            }

        }else{
            System.out.println("对不起，当前搜索的不是文件夹");
        }
    }
}
