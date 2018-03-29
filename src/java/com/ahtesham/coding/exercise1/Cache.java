package com.ahtesham.coding.exercise1;

public interface Cache<K,V> {

    public void put(K key,V value);

    public V get(Object key);
}
