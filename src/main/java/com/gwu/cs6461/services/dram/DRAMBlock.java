package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;

/**
 * Defines what DRAM block does
 */
public interface DRAMBlock {
    int MIN_OFFSET_VALUE = 0;
    int MAX_OFFSET_VALUE = MachineProps.DRAM_BLOCK_WORD_SIZE - 1;
    int MIN_BLOCK_NUM_VALUE = 0;
    int MAX_BLOCK_NUM_VALUE = DRAMAddress.MAX_VALUE / MachineProps.DRAM_BLOCK_WORD_SIZE;

    void write(int offset, DRAMData data);
    DRAMData read(int offset);
}
