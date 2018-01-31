package com.gwu.cs6461.services.instruction.arithmeticlogic;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * AIR Instruction
 */
public class AIRImpl implements Instruction {
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
    public AIRImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
