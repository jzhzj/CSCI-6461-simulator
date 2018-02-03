package com.gwu.cs6461.services.cpu;

/**
 * Defines what CPU does
 */
public interface CPU {

    /**
     * trigger CPU to work, processing instructions in current machine state
     */
    void resume();

    /**
     * CPU finishes the ongoing instruction, then pauses, ex. HALT instruction
     */
    void pause();

    /**
     * CPU pauses after processing the given number of instructions
     * @param count number of instructions to process
     */
    void pauseAfter(int count);


    /**
     * clears all register data, usually happens when machine shuts down or reboots
     */
    void reset();
}
