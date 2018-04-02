package com.ahtesham.coding.exercise1;


import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println("dskj");
        CacheImpl.INSTANCE.put("hello","Jack");
        System.out.println(CacheImpl.INSTANCE.get("hello"));
    }
}
