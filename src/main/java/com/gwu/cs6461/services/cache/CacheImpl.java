package com.gwu.cs6461.services.cache;

/**
 * Singleton
 * Cache
 */
public class CacheImpl implements Cache {

    private static CacheImpl ourInstance = new CacheImpl();

    public static CacheImpl getInstance() {
        return ourInstance;
    }

    private CacheImpl() {

    }


}
