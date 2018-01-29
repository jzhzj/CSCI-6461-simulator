package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.util.Binary;

/**
 * DRAM data at each address, represented in 16 bits = 1 word
 * TODO to be implemented
 */
public class DRAMData implements Binary{

    private int data;

    @Override
    public int getDecimalValue() {
        return data;
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
        data = literalValue;
    }
}
