package com.gwu.cs6461.services.cpu;

/**
 * Defines what CPU does
 */
public interface CPU {
    void run();
    void halt();
    void singleStep();
    void reset();
}
