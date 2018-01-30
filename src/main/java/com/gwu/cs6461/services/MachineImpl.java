package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.CPU;
import com.gwu.cs6461.services.cpu.CPUImpl;
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

    private CPU cpu = new CPUImpl();
    private DRAM dram = new DRAMImpl();
}
