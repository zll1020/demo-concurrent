package com.example.concurrent.democoncurrent.jmm.utils.volatiletest;

import java.util.concurrent.TimeUnit;

public class VisibilityDemo1 {
    // 状态标识
    private static boolean is = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (VisibilityDemo1.is) {
                    synchronized (this) {
                        i++;
                    }
                }
                System.out.println(i);
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 设置is为false，使上面的线程结束while循环
        VisibilityDemo1.is = false;
        System.out.println("被置为false了.");
    }
}
