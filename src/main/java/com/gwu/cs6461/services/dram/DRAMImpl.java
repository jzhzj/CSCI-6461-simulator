package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;

/**
 * DRAM stores 1 word (16 bit) at each location (address).
 * Total capacity = 4096 (2^12) words
 */
public class DRAMImpl implements DRAM {

    private static DRAMImpl ourInstance = new DRAMImpl();

    public static DRAMImpl getInstance() {
        return ourInstance;
    }

    private DRAMImpl() {
        dramData = new DRAMData[MachineProps.DRAM_EXPAND_WORD_SIZE];
        for (int i = 0; i < dramData.length; i++) {
            dramData[i] = new DRAMDataImpl().setValue(0);
        }
    }

    private DRAMData[] dramData;

    @Override
    public DRAMData read(DRAMAddress address) {
        return dramData[address.getDecimalValue()];
    }

    @Override
    public void write(DRAMAddress address, DRAMData data) {
        dramData[address.getDecimalValue()] = data;
    }

    @Override
    public void reset() {
        for (int i = 0; i < dramData.length; i++) {
            dramData[i] = new DRAMDataImpl().setValue(0);
        }
    }
}
