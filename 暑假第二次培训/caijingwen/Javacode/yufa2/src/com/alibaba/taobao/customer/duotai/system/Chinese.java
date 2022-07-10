package com.alibaba.taobao.customer.duotai.system;
//implements 实现  Chinese是接口的实现类
public class Chinese implements Language{
    @Override
    public void voice() {
        System.out.println("你好，有什么能帮到你的吗?");
    }
}
