package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.alu.ALU;
import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.GPRImpl;
import com.gwu.cs6461.services.cpu.registers.IDXRImpl;
import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAM;
import com.gwu.cs6461.services.dram.DRAMImpl;

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
    private DRAM RAM;

    // general purpose registers: accumulators
    private List<Register> gp_regs = new ArrayList<>(4);
    private List<Register> index_regs = new ArrayList<>(3);


    public boolean isRunning() {
        return running;
    }

    @Override
    public void powerOn() {
        running = true;
        alu = new ALUImpl();
        RAM = new DRAMImpl();
        gp_regs.forEach(register -> new GPRImpl());
        index_regs.forEach(register -> new IDXRImpl());
    }

    @Override
    public void powerOff() {
        running = false;
        alu = null;
        RAM = null;
        gp_regs.clear();
        index_regs.clear();
    }
}
