package com.alibaba.taobao.customer.duotai.system;


public class CustomerService {
//    返回的类型值是一个接口，可以返回接口的实现类，并且可以new出来
    public Language contact(int areacode){
        if(areacode==86)return new Chinese();
        else return new English();
    }
    public static void main(String[] args) {
//        类实现了接口的话：前面是接口，因为接口是抽象的，故后面new时，要指向相应的实现类
        Language language1 =new Chinese();
        language1.voice();
        Language language2 =new English();
        language2.voice();
      CustomerService cs=new CustomerService();
      Language language3=cs.contact(86);
      language3.voice();


    }
}
