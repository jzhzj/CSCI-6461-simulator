package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what DRAM address does
 */
public interface DRAMAddress extends Binary {
    int MIN_VALUE = 0;
    int MAX_VALUE = MachineProps.DRAM_WORD_SIZE - 1;
    int getBlockNum();
    int getOffset();
}
