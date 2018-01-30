package com.gwu.cs6461.services.instruction;

/**
 *  16 bits Instruction
 *  operation code: 6 bits, refers to 64 possible operations
 *  IX: 2 bits, refers to index register X1 - X3, 0 value indicates no indexing
 *  R: 2 bits, refers to general purpose register r0 - r3
 *  I: 1 bit, 1 = indirect addressing, 0 = no indirect addressing
 *  Address: 5 bits, refers to 32 locations. To address all of memory, indexing will be required.
 *
 *  TODO not yet designed.
 */
public class InstructionImpl implements Instruction {

    // operation code, 6 bits
    private int opCode;


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
