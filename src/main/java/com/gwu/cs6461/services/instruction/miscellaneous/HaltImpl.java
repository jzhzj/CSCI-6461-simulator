package com.gwu.cs6461.services.instruction.miscellaneous;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Halt Instruction
 */
public class HaltImpl implements Instruction {

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
    public HaltImpl setValue(int literalValue) throws IllegalArgumentException {
        return this;
    }

}
