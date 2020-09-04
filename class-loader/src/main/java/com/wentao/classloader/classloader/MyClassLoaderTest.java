package com.wentao.classloader.classloader;


import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {

        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        //自定义加载器主要是实现自己得findClass方法
        protected Class<?> findClass(final String name)
                throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        //重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();

                    if (!name.startsWith("com.wentao.classloader")) {

                        c = this.getParent().loadClass(name);
                    } else {
                        c = findClass(name);
                    }

                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }

    }


    public static void main(String[] args) throws Exception {


        MyClassLoader myClassLoader = new MyClassLoader("C:/test");
        Class<?> clazz = myClassLoader.loadClass("com.wentao.classloader.model.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj, null);
        System.out.println(clazz.getClassLoader().getClass().getName());

        //模拟多个webapp，使用不同的类加载器，各自隔离
        MyClassLoader myClassLoader2 = new MyClassLoader("C:/test1");
        Class<?> clazz2 = myClassLoader2.loadClass("com.wentao.classloader.model.User1");
        Object obj2 = clazz2.newInstance();
        Method method2 = clazz2.getDeclaredMethod("sout", null);
        method2.invoke(obj2, null);
        System.out.println(clazz2.getClassLoader().getClass().getName());

    }

}

