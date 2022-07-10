package com.imooc.reflect;

public class fanshe {
    Foo foo1=new Foo();//foo1是Foo的实例对象
//    Foo这个类也是一个实例对象是Class的实例对象，任何一个Class的地理对象有三种表示方式
    Class c1=Foo.class;//世实际告诉我们任何一个类都有一个隐含的静态成员变量class
    Class c2=foo1.getClass();//该类的对象通过getClass方法,c1,c2表示了Foo类的类类型，一个类只可能是Class类的一个实例对象
//   第三种方法不建议，报错
}

class Foo{}