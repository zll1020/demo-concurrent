package com.example.concurrent.democoncurrent.coreknowledge.productandconsumer;

/**
 * Description:
 * User: zhangll
 * Date: 2020-05-03
 * Time: 15:48
 */
public class OldEvenWaitNotify {
    private static int count = 0;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Producer producer = new Producer();
        Thread threadOld = new Thread(producer);
        Thread threadEven = new Thread(producer);
        threadOld.start();
        threadEven.start();
    }

    static class Producer implements Runnable{


        @Override
        public void run() {
            while (count <=100){
                synchronized (lock){
                    System.out.println(count);
                    lock.notify();
                    count ++;
                    if (count <= 100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }




}

