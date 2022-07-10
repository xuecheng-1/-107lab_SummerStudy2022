package com.alibaba.taobao.customer.data01;

import com.alibaba.taobao.customer.data02.Data02;

public class Data03 {
    public static void main(String[] args) {
        Data01 data01 = new Data01();// 在相同的包名下，可以直接引入同一包名下的不同类名

        data01.saygoodbye();

        Data02 data02 = new Data02();// 不同包名下的class类相互引用时需要导入引用的包名

    }
}