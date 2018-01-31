package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * RFS Instruction
 */
public class RFSImpl implements Instruction {
    @Override
    public int getDecimalValue() {
        return 0;
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
    public RFSImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
