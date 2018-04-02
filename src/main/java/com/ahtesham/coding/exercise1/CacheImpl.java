package com.ahtesham.coding.exercise1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public enum CacheImpl implements Cache<String, String>{

    INSTANCE{

        private Map<String, String> kvStore= new ConcurrentHashMap<>();

        @Override
        public void put(String key, String value) {
            kvStore.put(key, value);
        }

        @Override
        public String get(String key) {
            return kvStore.get(key);
        }
    }
}
