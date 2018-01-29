package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.util.Binary;

/**
 * DRAM Address range from [0, 4096 = 2^12), represented in 12 bits.
 * TODO to be implemented.
 */
public class DRAMAddress implements Binary{

    private int address;

    @Override
    public int getDecimalValue() {
        return address;
    }

    @Override
    public String getBinary() {
        return null;
    }

    @Override
    public String getHex() {
        return null;
    }

    @Override
    public void setValue(int literalValue) {
        // TODO check out of range
        address = literalValue;
    }
}
