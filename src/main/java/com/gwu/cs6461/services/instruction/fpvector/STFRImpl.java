package com.gwu.cs6461.services.instruction.fpvector;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * STFR Instruction
 */
public class STFRImpl implements Instruction {
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
    public STFRImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
