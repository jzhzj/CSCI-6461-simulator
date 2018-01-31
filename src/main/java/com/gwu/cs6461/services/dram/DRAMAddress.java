package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;
import org.apache.commons.lang3.StringUtils;

/**
 * DRAM Address range from [0, 4096 = 2^12), represented in 12 bits.
 */
public class DRAMAddress implements Binary{

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = MachineProps.DRAM_EXPAND_WORD_SIZE - 1;

    private int address;

    @Override
    public int getDecimalValue() {
        return address;
    }

    @Override
    public String getBinary() {
        String unformatted = Integer.toBinaryString(address);
        if(unformatted.length() < MachineProps.IAR_REG_BIT_WIDTH){
            return StringUtils.leftPad(unformatted, MachineProps.IAR_REG_BIT_WIDTH, "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - MachineProps.IAR_REG_BIT_WIDTH);
        }
    }

    @Override
    public String getHex() {
        String unformatted = Integer.toHexString(address);
        int hexLength = MachineProps.IAR_REG_BIT_WIDTH * 2 / Byte.SIZE;
        if(unformatted.length() < hexLength){
            return StringUtils.leftPad(unformatted, hexLength, "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - hexLength);
        }
    }

    @Override
    public DRAMAddress setValue(int literalValue) throws IllegalArgumentException{
        if(literalValue < MIN_VALUE || literalValue > MAX_VALUE){
            throw new IllegalArgumentException();
        }
        address = literalValue;
        return this;
    }
}
