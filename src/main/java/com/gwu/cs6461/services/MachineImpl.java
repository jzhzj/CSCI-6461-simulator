package com.gwu.cs6461.services;

import java.util.ArrayList;
import java.util.List;

public class MachineImpl implements Machine{

    private static MachineImpl ourInstance = new MachineImpl();

    public static MachineImpl getInstance() {
        return ourInstance;
    }

    private MachineImpl() {

    }

    private boolean running = false;
    private ALU alu;
    private Memory memory;
    private List<Register> regular_regs = new ArrayList<>(4);
    private List<Register> index_regs = new ArrayList<>(3);


    public boolean isRunning() {
        return running;
    }

    @Override
    public void powerOn() {
        running = true;
        alu = new ALUImpl();
        memory = new MemoryImpl();
        regular_regs.forEach(register -> new RegisterImpl());
        index_regs.forEach(register -> new RegisterImpl());
    }

    @Override
    public void powerOff() {
        running = false;
        alu = null;
        memory = null;
        regular_regs.clear();
        index_regs.clear();
    }
}
