package com.wentao.li.Thread;


import java.util.concurrent.TimeUnit;

public class ThisMonitor {

    public synchronized void method1(){

        System.out.println(Thread.currentThread().getName()+"enter to method1");
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void method2(){
        synchronized (this) {

            System.out.println(Thread.currentThread().getName() + "enter to method2");
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        ThisMonitor thisMonitor2 = new ThisMonitor();
        new Thread(thisMonitor::method1,"T1").start();
        new Thread(thisMonitor2::method2,"T2").start();
    }

}
