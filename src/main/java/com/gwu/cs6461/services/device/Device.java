package com.gwu.cs6461.services.device;

import com.gwu.cs6461.util.Binary;

/**
 * Defines what IO Device does
 */
public interface Device {
    /**
     * Write buffer to device
     * @param inputBuffer buffer to write
     */
    void write(Binary inputBuffer);

    /**
     * Read buffer from device
     * @return output buffer from device
     */
    Binary read();
}
