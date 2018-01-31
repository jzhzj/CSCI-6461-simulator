package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * LDR Instruction
 */
public class LDRImpl implements Instruction {
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
    public LDRImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
