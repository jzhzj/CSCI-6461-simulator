package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.services.fault.IllegalMemoryAddressToReservedLocations;

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
     * Read a block of memory
     * @param blockNum block number
     * @return a block of memory
     */
    DRAMBlock readBlock(int blockNum);

    /**
     * Write data to given address
     * @param address memory address
     * @param data data to write
     */
    void write(DRAMAddress address, DRAMData data) throws IllegalMemoryAddressToReservedLocations;

    /**
     * Write a block of memory
     * @param blockNum block number
     * @param block block of data to write
     */
    void writeBlock(int blockNum, DRAMBlock block);

    /**
     * Write data to reserved address
     * @param address reserved memory address
     * @param data data to write
     */
    void writeToReservedAddress(DRAMAddress address, DRAMData data);

    /**
     * Clear all data in memory
     */
    void reset();
}
