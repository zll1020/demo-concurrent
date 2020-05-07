package com.example.concurrent.democoncurrent.coreknowledge.threadandobjectmethods;

/**
 * Description: wait 和 notify基本用法
 * 研究代码执行过程
 *
 * User: zhangll
 * Date: 2020-05-03
 * Time: 11:03
 */
public class Wait {

    public static Object object = new Object();

    static class Thread1 extends Thread{

        @Override
        public void run(){
            synchronized (object){
                System.out.println( Thread.currentThread().getName() + "开始执行了");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()  + "获取到了锁");
            }
        }
    }

    static class Thread2 extends Thread{

        @Override
        public void run(){
            synchronized (object){
                object.notify();
                System.out.println(Thread.currentThread().getName()  + "notify");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(100);
        thread2.start();
    }
}
