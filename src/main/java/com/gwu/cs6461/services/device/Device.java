package com.gwu.cs6461.services.device;


/**
 * Defines what IO Device does
 */
public interface Device<T> {
    /**
     * Write buffer to device
     * @param inputBuffer buffer to write
     */
    void write(T inputBuffer);

    /**
     * Read buffer from device
     * @return output buffer from device
     */
    T read();
}
