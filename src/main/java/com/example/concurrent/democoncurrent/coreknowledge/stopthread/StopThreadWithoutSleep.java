package com.example.concurrent.democoncurrent.coreknowledge.stopthread;

/**
 * Description: run方法内没有sleep或wait停止线程
 * User: zhangll
 * Date: 2020-05-01
 * Time: 21:25
 */
public class StopThreadWithoutSleep implements Runnable{

    public static void main(String[] args) throws Exception{

        Thread thread = new Thread( new StopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        int num = 0;
        while ( !Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE/2){
            if (num % 10000 == 0){
                System.out.println(num + "是一万的倍数");
            }
            num++;
        }
        System.out.println("线程结束了");
    }
}
