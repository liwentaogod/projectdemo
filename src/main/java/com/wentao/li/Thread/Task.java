package com.wentao.li.Thread;

public class Task implements Runnable {
    private final Object MUTEX = new Object();
    @Override
    public void run() {
        synchronized (MUTEX){
            System.out.println(123);
        }
    }
}
