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
    public DRAMBlock readBlock(int blockNum) throws IllegalArgumentException {
        if(blockNum > DRAMBlock.MAX_BLOCK_NUM_VALUE || blockNum < DRAMBlock.MIN_BLOCK_NUM_VALUE) {
            throw new IllegalArgumentException();
        }

        DRAMBlock block = new DRAMBlockImpl();
        int offset = 0;
        while (offset <= DRAMBlock.MAX_OFFSET_VALUE) {
            block.write(offset, dramData[blockNum * MachineProps.DRAM_BLOCK_WORD_SIZE + offset]);
            offset++;
        }
        return block;
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
    public void writeBlock(int blockNum, DRAMBlock block) throws IllegalArgumentException {
        if(blockNum > DRAMBlock.MAX_BLOCK_NUM_VALUE || blockNum < DRAMBlock.MIN_BLOCK_NUM_VALUE) {
            throw new IllegalArgumentException();
        }
        int offset = 0;
        while (offset <= DRAMBlock.MAX_OFFSET_VALUE) {
            dramData[blockNum * MachineProps.DRAM_BLOCK_WORD_SIZE + offset] = block.read(offset);
            offset++;
        }
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
