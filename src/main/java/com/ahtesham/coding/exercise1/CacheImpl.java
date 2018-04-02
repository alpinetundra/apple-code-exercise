package com.ahtesham.coding.exercise1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
public enum CacheImpl implements Cache<String, String>{

    INSTANCE{
        private int size = 100;
        private Map<String, String> kvStore= new ConcurrentHashMap<>();

        private Queue<String> keyList = new LinkedList<>();

        @Override
        public void put(String key, String value) {
            if(kvStore.size() > size){
                kvStore.remove(keyList.poll());
            }
            keyList.add(key);
            kvStore.put(key, value);
        }

        @Override
        public String get(String key) {
            keyList.poll();
            keyList.add(key);
            return kvStore.get(key);
        }

        public void changeSize(int newSize){
            if(newSize > size){
                size = newSize;
            }
        }
    }
}
