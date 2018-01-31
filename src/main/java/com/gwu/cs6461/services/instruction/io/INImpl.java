package com.gwu.cs6461.services.instruction.io;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * IN Instruction
 */
public class INImpl implements Instruction {
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
    public INImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
