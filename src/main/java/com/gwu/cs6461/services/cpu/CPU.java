package com.gwu.cs6461.services.cpu;

/**
 * Defines what CPU does
 */
public interface CPU {
    /**
     * clears all register data, usually happens when machine shuts down or reboots
     */
    void reset();

}
