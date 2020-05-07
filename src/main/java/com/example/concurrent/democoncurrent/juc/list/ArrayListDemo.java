package com.example.concurrent.democoncurrent.juc.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            // iterator.remove();// IllegalStateException
            arrayList.remove(iterator.next()); // ConcurrentModificationException
        }
    }
}
