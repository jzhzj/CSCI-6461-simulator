package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.dram.DRAM;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Singleton
 * Control Unit: the most important part of CPU
 */
public class ControlUnitImpl implements ControlUnit {

    private static ControlUnitImpl ourInstance = new ControlUnitImpl();

    public static ControlUnitImpl getInstance() {
        return ourInstance;
    }

    private ControlUnitImpl() {

    }

    private DRAM dram = DRAMImpl.getInstance();

    @Override
    public void fetch(DRAMAddress address) {
        dram.read(address);
    }

    @Override
    public void decode(Instruction instruction) {

    }

    @Override
    public void execute(Instruction instruction) {

    }
}
