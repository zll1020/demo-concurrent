package com.example.concurrent.democoncurrent.recursion;

/**
 * Description: 可重入
 * User: zhangll
 * Date: 2020-05-01
 * Time: 09:16
 */
public class SynchronizedRecursion  {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion synchronizedRecursion = new SynchronizedRecursion();
        synchronizedRecursion.method1();
        System.out.println("----------------");
        synchronizedRecursion.method2();
        System.out.println("----------------");
        synchronizedRecursion.method4();
    }

    /**
     * 证明一个方法是可重入的
     */
    private synchronized void method1() {
        System.out.println("method1，a="+a);
        if (a == 0){
            a++;
            method1();
        }
    }

    /**
     * 不同的方法可重入
     */
    private synchronized void method2(){
        System.out.println(" method2");
        a = 1;
        method1();
    }

    /**
     * 不同类的方法可重入
     */
    private synchronized void method4(){
        System.out.println(" method4");
        SynchronizedRecursionCopy copy = new SynchronizedRecursionCopy();
        copy.method3();
    }


}
