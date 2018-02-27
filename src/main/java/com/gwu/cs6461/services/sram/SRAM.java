package com.gwu.cs6461.services.sram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressToReservedLocations;
import com.gwu.cs6461.util.Cache;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMBlock;
import com.gwu.cs6461.services.dram.DRAMData;

/**
 * Defines what SRAM does
 */
public interface SRAM extends Cache<DRAMBlock> {
    int BLOCK_SIZE = MachineProps.SRAM_BLOCK_SIZE;

    DRAMData read(DRAMAddress address);
    void write(DRAMAddress address, DRAMData data) throws IllegalMemoryAddressToReservedLocations;
    void writeToReservedAddress(DRAMAddress address, DRAMData data);
}
