package com.gwu.cs6461.services.instruction.io;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * OUT Instruction
 */
public class OUTImpl implements Instruction {
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
    public OUTImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
