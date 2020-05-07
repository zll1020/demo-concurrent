package com.example.concurrent.democoncurrent.coreknowledge.threadsocurity;

/**
 * Description: 第二种安全问题，演示死锁
 * User: zhangll
 * Date: 2020-05-04
 * Time: 10:07
 */
public class MultiYhreadError implements Runnable{
    int flag = 1;
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        MultiYhreadError e1 = new MultiYhreadError();
        MultiYhreadError e2 = new MultiYhreadError();
        e1.flag = 1;
        e2.flag = 0;

        new Thread(e1).start();
        new Thread(e2).start();

    }

    @Override
    public void run() {
        if (flag == 1){
            synchronized (object1){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("1");
                }
            }
        }
        if (flag == 0){
            synchronized (object2){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("0");
                }
            }
        }
    }
}
