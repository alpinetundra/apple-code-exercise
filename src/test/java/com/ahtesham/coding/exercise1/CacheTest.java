package com.ahtesham.coding.exercise1;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class CacheTest {

    @Test
    public void testAddToCache(){
        CacheImpl.INSTANCE.put("A100","Jack Smith");
        assertEquals("Jack Smith", CacheImpl.INSTANCE.get("A100"));
    }

    //test for maxsize;
    @Test
    public void testMaxCache(){
        IntStream.of(110).forEach((i) -> CacheImpl.INSTANCE.put(String.valueOf(i), "same value"));
        assertNull(CacheImpl.INSTANCE.get(String.valueOf("1")));
    }
    //test for synchronous threading

    @Test
    public void testSingleton(){
       Thread t1 = new Thread(){

       };
    }

}
