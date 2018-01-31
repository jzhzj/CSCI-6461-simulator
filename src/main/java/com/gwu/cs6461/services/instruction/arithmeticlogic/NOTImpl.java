package com.gwu.cs6461.services.instruction.arithmeticlogic;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * NOT Instruction
 */
public class NOTImpl implements Instruction {
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
    public NOTImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
