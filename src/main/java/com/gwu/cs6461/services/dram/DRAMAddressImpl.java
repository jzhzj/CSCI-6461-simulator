package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressBeyondMax;
import org.apache.commons.lang3.StringUtils;

/**
 * DRAM Address range from [0, 2048), represented in 12 bits.
 */
public class DRAMAddressImpl implements DRAMAddress {

    private int address;

    @Override
    public int getDecimalValue() {
        return address;
    }

    @Override
    public String getBinaryValue() {
        String unformatted = Integer.toBinaryString(address);
        if(unformatted.length() < MachineProps.IAR_REG_BIT_WIDTH){
            return StringUtils.leftPad(unformatted, MachineProps.IAR_REG_BIT_WIDTH, "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - MachineProps.IAR_REG_BIT_WIDTH);
        }
    }

    @Override
    public String getHexValue() {
        String unformatted = Integer.toHexString(address);
        int hexLength = MachineProps.IAR_REG_BIT_WIDTH * 2 / Byte.SIZE;
        if(unformatted.length() < hexLength){
            return StringUtils.leftPad(unformatted, hexLength, "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - hexLength);
        }
    }

    @Override
    public DRAMAddressImpl setDecimalValue(int decimalValue) throws IllegalMemoryAddressBeyondMax {
        if(decimalValue < MIN_VALUE || decimalValue > MAX_VALUE){
            throw new IllegalMemoryAddressBeyondMax();
        }
        address = decimalValue;
        return this;
    }

    @Override
    public DRAMAddressImpl setDecimalValue(String decimalValue) throws IllegalArgumentException {
        try{
            int value = Integer.parseInt(decimalValue);
            return setDecimalValue(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public DRAMAddressImpl setBinaryValue(String binaryValue) throws IllegalArgumentException {
        try{
            int value = Integer.parseInt(binaryValue, 2);
            return setDecimalValue(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getBlockNum() {
        return address / MachineProps.DRAM_BLOCK_WORD_SIZE;
    }

    @Override
    public int getOffset() {
        return address % MachineProps.DRAM_BLOCK_WORD_SIZE;
    }
}
