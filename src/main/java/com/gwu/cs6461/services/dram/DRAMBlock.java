package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;

/**
 * Defines what DRAM block does
 */
public interface DRAMBlock {
    int WORD_SIZE = MachineProps.DRAM_BLOCK_WORD_SIZE;
    int MIN_OFFSET_VALUE = 0;
    int MAX_OFFSET_VALUE = WORD_SIZE - 1;
    int MIN_BLOCK_ID_VALUE = 0;
    int MAX_BLOCK_ID_VALUE = DRAMAddress.MAX_VALUE / MachineProps.DRAM_BLOCK_WORD_SIZE;

    /**
     * Write data into block
     * @param offset block inner offset
     * @param data DRAM data
     */
    void write(int offset, DRAMData data);

    /**
     * Read data from block
     * @param offset block inner offset
     * @return DRAM data
     */
    DRAMData read(int offset);
}
