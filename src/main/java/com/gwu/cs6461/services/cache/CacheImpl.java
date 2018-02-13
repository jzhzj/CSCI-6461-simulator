package com.gwu.cs6461.services.cache;

/**
 * A fully associative, unified cache.
 * sits between memory and the rest of the processor.
 * A vector having a format similar to that described in the lecture notes.
 * 16 cache lines
 */
public class CacheImpl implements Cache {

    private static CacheImpl ourInstance = new CacheImpl();

    public static CacheImpl getInstance() {
        return ourInstance;
    }

    private CacheImpl() {

    }


}
