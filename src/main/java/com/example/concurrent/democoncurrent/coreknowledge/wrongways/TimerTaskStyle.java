package com.example.concurrent.democoncurrent.coreknowledge.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Description: 用定时器方式创建线程
 * User: zhangll
 * Date: 2020-05-01
 * Time: 16:53
 */
public class TimerTaskStyle {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
