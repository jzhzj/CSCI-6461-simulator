package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what DRAM address does
 */
public interface DRAMAddress extends Binary {
    int MIN_VALUE = 0;
    int MAX_VALUE = MachineProps.DRAM_WORD_SIZE - 1;

    /**
     * Get the id of DRAM block that this address belongs to
     * @return block id
     */
    int getBlockNum();

    /**
     * Get the offset within the DRAM block that this address belongs to
     * @return block inner offset
     */
    int getOffset();
}
