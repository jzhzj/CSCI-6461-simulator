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
     * Read a block of DRAM data
     * @param blockId block id
     * @return DRAM data block
     */
    DRAMBlock readBlock(int blockId);

    /**
     * Write data to given address
     * @param address memory address
     * @param data data to write
     */
    void write(DRAMAddress address, DRAMData data) throws IllegalMemoryAddressToReservedLocations;

    /**
     * Write a block of DRAM data
     * @param blockId block id
     * @param block data to write
     */
    void writeBlock(int blockId, DRAMBlock block);

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
