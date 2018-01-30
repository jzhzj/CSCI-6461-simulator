package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;

/**
 * DRAM Address range from [0, 4096 = 2^12), represented in 12 bits.
 */
public class DRAMAddress implements Binary{

    private int address;

    @Override
    public int getDecimalValue() {
        return address;
    }

    @Override
    public String getBinary() {
        return Integer.toBinaryString(address);
    }

    @Override
    public String getHex() {
        return Integer.toHexString(address);
    }

    @Override
    public void setValue(int literalValue) throws IllegalArgumentException{
        if(literalValue < 0 || literalValue > MachineProps.DRAM_EXPAND_WORD_SIZE - 1){
            throw new IllegalArgumentException();
        }
        address = literalValue;
    }
}
