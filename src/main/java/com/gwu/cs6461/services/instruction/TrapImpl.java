package com.gwu.cs6461.services.instruction;

/**
 * Trap Instruction
 */
public class TrapImpl implements Instruction{

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
    public void setValue(int literalValue) throws IllegalArgumentException {

    }
}
