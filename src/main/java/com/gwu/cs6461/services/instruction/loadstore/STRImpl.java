package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * STR Instruction
 */
public class STRImpl implements Instruction {
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
    public STRImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
