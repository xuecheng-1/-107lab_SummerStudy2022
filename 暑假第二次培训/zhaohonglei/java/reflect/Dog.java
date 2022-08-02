package com.itheima.reflect;

public class Dog {
    private String name;
    public Dog(){
    }

    public Dog(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("run");
    }


    /**/
    private void eat(){
        System.out.println("eat meat");
    }

    private String eat(String name){
        System.out.println("dog eat" + name);
        return "dog eat it happily";
    }

    public static void inAddr(){
        System.out.println("there is a dog inaddr");
    }
    /**/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
