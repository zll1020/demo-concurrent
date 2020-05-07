package com.example.concurrent.democoncurrent.coreknowledge.createthread;

/**
 * Description: 同时使用Runnable 和Thread 实现线程
 * User: zhangll
 * Date: 2020-05-01
 * Time: 16:35
 */
public class RunnableAndThreadStyle {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            // 实现Runnable
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }){
            // 继承Thread
            @Override
            public void run(){
                System.out.println("Thread");
            }
        }.start();

        // 结果：Thread
    }
}
