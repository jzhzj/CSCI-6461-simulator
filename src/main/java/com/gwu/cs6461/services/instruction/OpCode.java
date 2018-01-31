package com.gwu.cs6461.services.instruction;

import com.gwu.cs6461.util.Binary;

/**
 * Operation code: 6 bits
 * Refers to 64 possible operations, however, not so many in this one
 */
public class OpCode implements Binary {



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
