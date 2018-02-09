package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressToReservedLocations;

/**
 * Word addressable DRAM, stores 1 word (16 bit) at each location (address).
 * Total capacity = 2048 words
 */
public class DRAMImpl implements DRAM {

    private static DRAMImpl ourInstance = new DRAMImpl();

    public static DRAMImpl getInstance() {
        return ourInstance;
    }

    private DRAMImpl() {
        dramData = new DRAMData[MachineProps.DRAM_WORD_SIZE];
        for (int i = 0; i < dramData.length; i++) {
            dramData[i] = new DRAMDataImpl();
        }
    }

    private DRAMData[] dramData;

    @Override
    public DRAMData read(DRAMAddress address) {
        return dramData[address.getDecimalValue()];
    }

    @Override
    public void write(DRAMAddress address, DRAMData data) throws IllegalMemoryAddressToReservedLocations {
        if(address.getDecimalValue() < MachineProps.INSTRUCTION_START_ADDRESS){
            // trying to write reserved memory
            throw new IllegalMemoryAddressToReservedLocations();
        }
        dramData[address.getDecimalValue()] = data;
    }

    @Override
    public void writeToReservedAddress(DRAMAddress address, DRAMData data) {
        dramData[address.getDecimalValue()] = data;
    }

    @Override
    public void reset() {
        for (int i = 0; i < dramData.length; i++) {
            dramData[i] = new DRAMDataImpl();
        }
    }
}
