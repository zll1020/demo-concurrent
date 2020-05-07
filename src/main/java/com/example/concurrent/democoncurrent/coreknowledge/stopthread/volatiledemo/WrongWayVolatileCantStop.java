package com.example.concurrent.democoncurrent.coreknowledge.stopthread.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description: 陷入阻塞时，volatile是无法停止线程的
 * 生产者生产很快，消费者消费很慢
 * 队列满了之后，生产者阻塞，等待消费者消费
 * User: zhangll
 * Date: 2020-05-02
 * Time: 19:28
 */
public class WrongWayVolatileCantStop {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        Product product = new Product(blockingQueue);
        Thread producer = new Thread(product);
        producer.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(blockingQueue);
        while (consumer.needMoreNums()){
            System.out.println(blockingQueue.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要数据了");
        product.canceld = true;
    }

}

class Product implements Runnable{

    public volatile  boolean canceld = false;

    BlockingQueue blockingQueue;

    public Product(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceld && num <= Integer.MAX_VALUE/2){
                if (num % 100 ==0){
                    System.out.println(num + "是100的倍数");
                    blockingQueue.put(num);
                }
                num++;
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("生产者停止运行");
        }

    }
}

class Consumer  {

    BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public boolean needMoreNums(){
        if (Math.random() > 0.95){
            return false;
        }else {
            return true;
        }
    }
}