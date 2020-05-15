package com.wentao.li.ThreadTest;

import com.wentao.li.Thread.Task;
import com.wentao.li.Thread.TicketWindowRunnable;

public class ThreadTest {

    public static void main(String[] args) {
//        ticketTest();
        Task task = new Task();
        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }

    private static void ticketTest() {
        long start = System.currentTimeMillis();
        TicketWindowRunnable task = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(task, "一号窗口");
        Thread windowThread2 = new Thread(task, "二号窗口");
        Thread windowThread3 = new Thread(task, "三号窗口");
        Thread windowThread4 = new Thread(task, "四号窗口");
        windowThread3.start();
        windowThread1.start();
        windowThread2.start();
        windowThread4.start();
        System.out.println("累计耗时："+(System.currentTimeMillis()-start));
    }
}
