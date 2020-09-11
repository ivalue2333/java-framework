package com.iota.core.base.sta;

public class StaticDemo {

    // 我们用Static表示变量的级别，一个类中的静态变量，不属于类的对象或者实例。因为静态变量与所有的对象实例共享，因此他们不具线程安全性。
    private static int count;

    // 通常，静态变量常用final关键来修饰，表示通用资源或可以被所有的对象所使用。
    /*
        final是Java的一个保留关键字, 可以声明成员变量、方法、类以及局部变量. 被声明final的变量, 一但赋值便不能再次修改.
        编译器会检查代码,如果你试图将变量再次初始化的话,编译器会报编译错误.final变量经常和static关键字一起使用作为常量.
     */
    private static final int size = 4;

    public static void main(String[] args) {
        StaticDemo.count += 1;
        System.out.println(StaticDemo.count);

        System.out.println(StaticDemo.size);
    }
}