package com.alibaba.taobao.customer.jicheng;

public class Mark85 extends Mark1 {
    private void repair() {
        System.out.println("利用纳米技术生成防御护盾");
    }

    public static void main(String[] args) {
        Mark85 mark85 = new Mark85();
        mark85.name = "马克85";
        mark85.color = "红色";
        mark85.movie = "复仇者联盟4";
        mark85.description();
        mark85.repair();
    }
}