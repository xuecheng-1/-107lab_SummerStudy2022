package com.alibaba.taobao.customer.jicheng;
//extends 继承关键字，后面是父类
public class Hulk extends Mark1{
    private void repair(){
        System.out.println("弹射备件替换战损组件");
    }
    public static void main(String[] args) {
        Hulk hulk=new Hulk();
        hulk.name="反浩克装甲";
        hulk.color="红色";
        hulk.movie="复仇者联盟";
        hulk.description();
        hulk.repair();

    }


}
