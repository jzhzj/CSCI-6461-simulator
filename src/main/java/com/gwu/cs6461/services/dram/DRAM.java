package com.gwu.cs6461.services.dram;

/**
 * Defines what memory does
 */
public interface DRAM {

    /**
     * Read data from address
     * @param address memory address
     * @return data stored in memory
     */
    DRAMData read(DRAMAddress address);

    /**
     * Write data to given address
     * @param address memory address
     * @param data data to write
     */
    void write(DRAMAddress address, DRAMData data);

    /**
     * Clear all data in memory
     */
    void reset();

    /**
     * initialize memory, and reserve address 0 - 8
     */
    void init();
}
