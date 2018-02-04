package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.instruction.Instruction;

import java.util.Observable;

/**
 * Singleton
 * Instruction Register
 * It holds the current instruction that is being executed
 */
public class IRImpl extends Observable implements Register<Instruction>{

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
        setChanged();
        notifyObservers();
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
