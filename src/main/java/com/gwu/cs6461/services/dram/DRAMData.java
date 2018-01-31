package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;
import org.apache.commons.lang3.StringUtils;

/**
 * DRAM data at each address, represented in 16 bits = 2 bytes = 1 word
 */

public class DRAMData implements Binary {

    public static final int MIN_VALUE = - (int) Math.pow(2, (MachineProps.WORD_BIT_WIDTH / 2));
    public static final int MAX_VALUE = (int) Math.pow(2, (MachineProps.WORD_BIT_WIDTH / 2)) - 1;

    private int data;

    @Override
    public int getDecimalValue() {
        return data;
    }

    @Override
    public String getBinary() {
        String unformatted = Integer.toBinaryString(data);
        if(unformatted.length() < MachineProps.WORD_BIT_WIDTH){
            return StringUtils.leftPad(unformatted, MachineProps.WORD_BIT_WIDTH, data < 0 ? "1" : "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - MachineProps.WORD_BIT_WIDTH);
        }

    }

    @Override
    public String getHex() {
        String unformatted = Integer.toHexString(data);
        int hexLength = MachineProps.WORD_BIT_WIDTH / Byte.SIZE * 2;
        if(unformatted.length() < hexLength){
            return StringUtils.leftPad(unformatted, hexLength, data < 0 ? "f" : "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - hexLength);
        }
    }

    @Override
    public DRAMData setValue(int literalValue) throws IllegalArgumentException{
        if(literalValue <  MIN_VALUE || literalValue > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        data = literalValue;
        return this;
    }
}
