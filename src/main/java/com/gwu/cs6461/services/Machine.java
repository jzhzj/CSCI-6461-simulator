package com.gwu.cs6461.services;

import com.gwu.cs6461.services.fault.IllegalOperationCode;

/**
 * Defines what machine does
 */
public interface Machine {

    /**
     * Run machine at current machine state
     */
    void run() throws IllegalOperationCode;

    /**
     * Pause machine
     */
    void halt();

    /**
     * Run single step to the next instruction
     */
    void singleStep() throws IllegalOperationCode;

    /**
     * Initialize / Reset machine
     */
    void ipl();
}
