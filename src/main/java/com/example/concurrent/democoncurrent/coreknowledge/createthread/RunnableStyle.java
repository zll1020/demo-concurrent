package com.example.concurrent.democoncurrent.coreknowledge.createthread;

/**
 * Description: 用runnable创建线程
 * User: zhangll
 * Date: 2020-05-01
 * Time: 16:23
 */
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run(){
        System.out.println("实现Runnable 创建线程");
    }

}
