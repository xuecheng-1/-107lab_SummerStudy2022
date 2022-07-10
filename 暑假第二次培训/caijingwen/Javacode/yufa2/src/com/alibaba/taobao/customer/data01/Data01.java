package com.alibaba.taobao.customer.data01;

import com.alibaba.taobao.customer.data02.Data02;

import javax.crypto.spec.PSource;

public class Data01 {
    public String name;//共有
    private  void sayhello(){//私有，只有自己当前类才能引用
        System.out.println("Hello World!");
    }
    void saygoodbye(){//默认，与自己在同一包下的类都能引用
        System.out.println("Good ,bye!");
    }
    public static void main(String[] args) {
        Data01 data01=new Data01();
        data01.sayhello();
        data01.saygoodbye();


    }
}
