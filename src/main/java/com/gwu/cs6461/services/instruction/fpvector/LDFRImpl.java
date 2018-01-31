package com.gwu.cs6461.services.instruction.fpvector;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * LDFR Instruction
 */
public class LDFRImpl implements Instruction {
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
    public LDFRImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
