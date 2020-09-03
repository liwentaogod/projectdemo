package com.wentao.classloader.classloader;

/**
 * 测试动态加载
 * 有些类不是一次就全部加载的，使用到的类才会加载
 */
public class TestDynamicLoad {

    static {
        System.out.println("*************load TestDynamicLoad************");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("*************load test************");
        B b = null; //B不会加载，除非这里执行 new B()
    }
}

class A {

    public A() {
        System.out.println("*************initial A************");
    }

    static {
        System.out.println("*************load A************");
    }
}

class B {
    static {
        System.out.println("*************load B************");
    }

    public B() {
        System.out.println("*************initial B************");
    }
}
    
