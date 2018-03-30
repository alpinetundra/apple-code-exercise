package com.ahtesham.coding.exercise1;

import java.util.concurrent.ConcurrentHashMap;
public enum CacheImpl implements Cache {

    INSTANCE{

        private ConcurrentHashMap kvStore= new ConcurrentHashMap();

        @Override
        public void put(Object key, Object value) {
            kvStore.put(key, value);
        }

        @Override
        public Object get(Object key) {
            return kvStore.get(key);
        }
    }
}
