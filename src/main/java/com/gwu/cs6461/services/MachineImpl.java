package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.ALU;
import com.gwu.cs6461.services.cpu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.cpu.registers.RegisterImpl;
import com.gwu.cs6461.services.dram.RAM;
import com.gwu.cs6461.services.dram.RAMImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton
 */
public class MachineImpl implements Machine{

    private static MachineImpl ourInstance = new MachineImpl();

    public static MachineImpl getInstance() {
        return ourInstance;
    }

    private MachineImpl() {

    }

    private boolean running = false;
    private ALU alu;
    private RAM RAM;

    // general purpose registers: accumulators
    private List<Register> regular_regs = new ArrayList<>(4);
    private List<Register> index_regs = new ArrayList<>(3);


    public boolean isRunning() {
        return running;
    }

    @Override
    public void powerOn() {
        running = true;
        alu = new ALUImpl();
        RAM = new RAMImpl();
        regular_regs.forEach(register -> new RegisterImpl());
        index_regs.forEach(register -> new RegisterImpl());
    }

    @Override
    public void powerOff() {
        running = false;
        alu = null;
        RAM = null;
        regular_regs.clear();
        index_regs.clear();
    }
}
