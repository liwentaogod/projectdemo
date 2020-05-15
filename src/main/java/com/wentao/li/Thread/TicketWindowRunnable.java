package com.wentao.li.Thread;

public class TicketWindowRunnable implements Runnable{

    private int index =1;
    private final static int MAX =5000;
    private final static Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized(MUTEX){
            while (index<=MAX){
                System.out.println(Thread.currentThread()+" 的号码是："+(index++));
            }
        }

    }
}
