package com.gwu.cs6461.services;

/**
 * Defines what machine does
 */
public interface Machine {

    /**
     * Run machine at current machine state
     */
    void run();

    /**
     * Pause machine
     */
    void halt();

    /**
     * Run single step to the next machine state
     */
    void singleStep();

    /**
     * Initialize / Reset machine
     */
    void ipl();
}
