package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * STX Instruction
 */
public class STXImpl implements Instruction {
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
    public STXImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
