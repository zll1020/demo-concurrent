package com.example.concurrent.democoncurrent.coreknowledge.createthread;

/**
 * Description: 用thread实现线程
 * User: zhangll
 * Date: 2020-05-01
 * Time: 16:26
 */
public class ThreadStyle extends Thread {

    public static void main(String[] args) {
        new ThreadStyle().start();
    }

    @Override
    public void run(){
        System.out.println("使用Thread实现线程");
    }
}
