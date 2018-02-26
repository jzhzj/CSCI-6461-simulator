package com.gwu.cs6461.services.device;


import java.util.concurrent.Future;

/**
 * Defines what IO Device does
 */
public interface Device<T, V> {
    /**
     * Write buffer to device
     * @param inputBuffer buffer to write
     */
    void write(T inputBuffer);

    /**
     * Read buffer from device
     * @return output buffer from device
     */
    Future<T> read();

    /**
     * Take input from user
     * @param value user input
     */
    void input(V value);

    /**
     * Show value to user
     * @return value to display
     */
    V output();

    /**
     * Clear device data
     */
    void reset();
}
