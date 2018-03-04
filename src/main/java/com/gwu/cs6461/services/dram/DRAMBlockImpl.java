package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;

public class DRAMBlockImpl implements DRAMBlock {

    private DRAMData[] blockData = new DRAMData[MachineProps.DRAM_BLOCK_WORD_SIZE];

    @Override
    public void write(int offset, DRAMData data) throws IllegalArgumentException{
        if(offset > MAX_OFFSET_VALUE || offset < MIN_OFFSET_VALUE) {
            throw new IllegalArgumentException();
        }
        blockData[offset] = data;
    }

    @Override
    public DRAMData read(int offset) throws IllegalArgumentException {
        if(offset > MAX_OFFSET_VALUE || offset < MIN_OFFSET_VALUE) {
            throw new IllegalArgumentException();
        }
        return blockData[offset];
    }
}
