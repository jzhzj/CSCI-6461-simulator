package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;
import org.apache.commons.lang3.StringUtils;

/**
 * DRAM data at each address, represented in 16 bits = 2 bytes = 1 word
 * TODO to be implemented
 */
public class DRAMData implements Binary {

    public static final int MIN_VALUE = - (int) Math.pow(2, (MachineProps.WORD_BIT_WIDTH / 2));
    public static final int MAX_VALUE = (int) Math.pow(2, (MachineProps.WORD_BIT_WIDTH / 2)) - 1;;

    private int data;

    @Override
    public int getDecimalValue() {
        return data;
    }

    @Override
    public String getBinary() {
        return StringUtils.leftPad(Integer.toBinaryString(data), 16, data < 0 ? "1" : "0");
    }

    @Override
    public String getHex() {
        return Integer.toHexString(data);
    }

    @Override
    public void setValue(int literalValue) throws IllegalArgumentException{
        if(literalValue <  MIN_VALUE || literalValue > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        data = literalValue;
    }
}
