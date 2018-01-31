package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.cpu.registers.IRImpl;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMImpl;

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

    @Override
    public void fetch() {
        // memory address : PC -> MAR
        MARImpl.getInstance().write(IARImpl.getInstance().read());
        // read memory data using the address, then write it to MBR : M (MAR) -> MBR
        MBRImpl.getInstance().write(DRAMImpl.getInstance().read(MARImpl.getInstance().read()));
        // MBR -> IR
        IRImpl.getInstance().write(MBRImpl.getInstance().read());
        // PC -> PC + 1
        IARImpl.getInstance().write(new DRAMAddress().setValue(IARImpl.getInstance().read().getDecimalValue() + 1));
    }

    @Override
    public void decode() {
        IRImpl.getInstance().read();
    }

    @Override
    public void execute() {

    }
}
