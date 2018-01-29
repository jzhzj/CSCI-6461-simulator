package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;

/**
 * TODO need more detailed design.
 */
public class DRAMImpl implements DRAM {

    private DRAMData[] dramData = new DRAMData[MachineProps.DRAM_WORD_SIZE];

    @Override
    public DRAMData read(DRAMAddress address) {
        return null;
    }

    @Override
    public void write(DRAMAddress address, DRAMData data) {

    }
}
