package com.alibaba.taobao.customer.ArrayListSample;

import java.util.ArrayList;
import java.util.List;

public class Arraylistname {
    public static void main(String[] args) {
//        使用List接口
        List<String> listname=new ArrayList<String>();
//        在数组的末尾追加元素
        listname.add("红楼梦");
        listname.add("西游记");
        listname.add("三国演义");
        listname.add("水浒传");
//        在数组的相应位置追加元素
        listname.add(0,"镜花缘");
        System.out.println(listname);
//        提取到某一元素
        String a=listname.get(1);
        System.out.println(a);
//        数组的大小
        int size =listname.size();
        System.out.println(size);
//        删除指定位置的元素
        listname.remove(2);
        System.out.println(listname);
//        删除最后一个元素，组合类型
        listname.remove(listname.size()-1);
        System.out.println(listname);
//        遍历列表所有元素，并把元素赋值给book
        for(String book:listname){
            System.out.println("《"+book+"》");
        }


    }
}
