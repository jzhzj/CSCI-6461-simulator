package com.gwu.cs6461.services.dram;

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
        dramData = new DRAMData[WORD_SIZE];
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
    public DRAMBlock readBlock(int blockId) throws IllegalArgumentException {
        if(blockId > DRAMBlock.MAX_BLOCK_ID_VALUE || blockId < DRAMBlock.MIN_BLOCK_ID_VALUE) {
            throw new IllegalArgumentException();
        }

        DRAMBlock block = new DRAMBlockImpl();
        int offset = 0;
        while (offset <= DRAMBlock.MAX_OFFSET_VALUE) {
            block.write(offset, dramData[blockId * DRAMBlock.WORD_SIZE + offset]);
            offset++;
        }
        return block;
    }

    @Override
    public void write(DRAMAddress address, DRAMData data) throws IllegalMemoryAddressToReservedLocations {
        if(address.getDecimalValue() < DRAMAddress.INSTRUCTION_START){
            // trying to write reserved memory
            throw new IllegalMemoryAddressToReservedLocations();
        }
        dramData[address.getDecimalValue()] = data;
    }

    @Override
    public void writeBlock(int blockId, DRAMBlock block) throws IllegalArgumentException {
        if(blockId > DRAMBlock.MAX_BLOCK_ID_VALUE || blockId < DRAMBlock.MIN_BLOCK_ID_VALUE) {
            throw new IllegalArgumentException();
        }
        int offset = 0;
        while (offset <= DRAMBlock.MAX_OFFSET_VALUE) {
            dramData[blockId * DRAMBlock.WORD_SIZE + offset] = block.read(offset);
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
