package com.gwu.cs6461.services.sram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cache.Cache;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMBlock;
import com.gwu.cs6461.services.dram.DRAMData;

/**
 * Defines what SRAM does
 */
public interface SRAM extends Cache<DRAMBlock> {
    int MAX_BLOCK_CAPACITY = MachineProps.SRAM_BLOCK_SIZE;

    DRAMData read(DRAMAddress address);
    void write(DRAMAddress address, DRAMData data);
}
