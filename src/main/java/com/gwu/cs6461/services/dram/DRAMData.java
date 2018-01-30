package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
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
        return Integer.toBinaryString(data);
    }

    @Override
    public String getHex() {
        return Integer.toHexString(data);
    }

    @Override
    public void setValue(int literalValue) throws IllegalArgumentException{
        if(literalValue < MachineProps.DRAM_DATA_MIN_VALUE || literalValue > MachineProps.DRAM_DATA_MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        data = literalValue;
    }

    public static void main(String[] args) {
        DRAMData dd = new DRAMData();
        dd.setValue(8);
        System.out.println(dd.getBinary());
        System.out.println(dd.getHex());
    }
}
