package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Instruction Register
 * It holds the current instruction that is being executed
 */
public class IRImpl implements Register<Instruction>{

    private Instruction currentIns;

    @Override
    public void write(Instruction instruction) {
        currentIns = instruction;
    }

    @Override
    public Instruction read() {
        return currentIns;
    }
}
