package com.wentao.classloader.classloader;

import sun.misc.Launcher;

import java.net.URL;

public class TestJDKClassLoader {

    public static void main(String[] args) {

        //类使用的各种类加载器
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());

        System.out.println("=============华丽的分割线============");
        //查看类加载器的父子关系
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootClassLoader = extClassLoader.getParent();
        System.out.println("the appClassLoader: "+appClassLoader);
        System.out.println("the extClassLoader: "+extClassLoader);
        System.out.println("the bootClassLoader: "+bootClassLoader);

        System.out.println("=============华丽的分割线============");
        //查看类加载器加载的jar以及文件
        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i <urLs.length ; i++) {
            System.out.println(urLs[i]);
        }

        System.out.println();
        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));


    }

}
