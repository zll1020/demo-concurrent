package com.example.concurrent.democoncurrent.coreknowledge.stopthread.volatiledemo;

/**
 * Description: volatile 设置boolean标记位 停止线程，看似可行
 * User: zhangll
 * Date: 2020-05-02
 * Time: 19:19
 */
public class WrongWayVolatile implements Runnable{

    private volatile  boolean canceld = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceld && num <= Integer.MAX_VALUE/2){
                if (num % 100 ==0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException{
        WrongWayVolatile wrongWayVolatile = new WrongWayVolatile();
        Thread thread = new Thread(wrongWayVolatile);
        thread.start();
        Thread.sleep(5000);
        wrongWayVolatile.canceld = true;
    }
}
