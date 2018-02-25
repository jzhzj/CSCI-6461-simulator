package com.gwu.cs6461.services.cache;

/**
 * Defines what cache does
 * @param <T> the data exchange type to the lower level
 */
public interface Cache<T> {
    T readLowerLevel(int id);
    void writeLowerLevel(int id, T data);
}
