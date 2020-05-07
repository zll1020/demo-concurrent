package com.example.concurrent.democoncurrent.coreknowledge.productandconsumer;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Description:
 * User: zhangll
 * Date: 2020-05-03
 * Time: 15:22
 */
public class ProducerAndConsumerModel {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer  producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(producer).start();
        new Thread(consumer).start();

    }

}


class Producer implements Runnable{

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0 ;i < 100 ;i++){
            storage.put();
        }
    }
}

class Consumer implements Runnable{

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0 ;i < 100 ;i++){
            storage.task();
        }
    }
}

class EventStorage{
    private int maxNum;
    private LinkedList<Date> storage;

    public EventStorage() {
        this.maxNum = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void put(){
        while (storage.size() ==10){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有" + storage.size() + "产品");
        notify();
    }

    public synchronized void task(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() + "还剩下" + storage.size());
        notify();
    }
}