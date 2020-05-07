package com.example.concurrent.democoncurrent.coreknowledge.stopthread;

/**
 * Description:run方法内有sleep或wait停止线程
 * User: zhangll
 * Date: 2020-05-01
 * Time: 22:00
 */
public class StopThreadWithSleep  {
    public static void main(String[] args) throws Exception{
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int num = 0;
                try {
                    while (!Thread.currentThread().isInterrupted() && num <=Integer.MAX_VALUE/2){
                        if (num % 100 == 0){
                            System.out.println(num + "是100的倍数");
                        }
                        num++;
                    }
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

}
