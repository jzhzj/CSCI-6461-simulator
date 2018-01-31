package com.gwu.cs6461.services.instruction.io;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * CHK Instruction
 */
public class CHKImpl implements Instruction {
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
    public CHKImpl setValue(int literalValue) throws IllegalArgumentException {
        return null;
    }
}
