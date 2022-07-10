package com.alibaba.taobao.customer.jicheng;


public class Mark1 {
    protected String name;
    protected  String color;
    protected String movie;
    protected void description(){
        System.out.println("型号: "+name);
        System.out.println("颜色: "+color);
        System.out.println("首次出现的电影: "+movie);
    }
    private void fire(){//不能继承到子类
        System.out.println("利用手臂燃料泵射出火焰");
    }

    public static void main(String[] args) {
        Mark1 mark1=new Mark1();
        mark1.name="马克1型";
        mark1.color="银灰色";
        mark1.movie="钢铁侠1";
        mark1.description();
        mark1.fire();

    }
}
