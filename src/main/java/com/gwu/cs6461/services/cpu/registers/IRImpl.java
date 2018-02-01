package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Singleton
 * Instruction Register
 * It holds the current instruction that is being executed
 */
public class IRImpl implements Register<Instruction>{

    private static IRImpl ourInstance = new IRImpl();

    public static IRImpl getInstance() {
        return ourInstance;
    }

    private IRImpl() {

    }

    private Instruction currentIns;

    @Override
    public void write(Instruction data) {
        currentIns = data;
    }

    @Override
    public Instruction read() {
        return currentIns;
    }

    @Override
    public void reset() {
        write(null);
    }
}
