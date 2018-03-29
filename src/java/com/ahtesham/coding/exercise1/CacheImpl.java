package com.ahtesham.coding.exercise1;

import java.util.concurrent.ConcurrentHashMap;

public enum CacheImpl implements Cache<K,V> {

    INSTANCE{

        private ConcurrentHashMap<K,V> kvStore= new ConcurrentHashMap<K,V>();

        @Override
        public void put(K key, V value) {
            kvStore.put(key, value);
        }

        @Override
        public V get(Object key) {
            return kvStore.get(key);
        }
    }
}
