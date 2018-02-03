package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.cpu.registers.IRImpl;
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
        DRAMAddress dramAddress = IARImpl.getInstance().read();
        DRAMImpl.getInstance().read(dramAddress).toInstruction().onFetch();
    }

    @Override
    public void decode() {
        IRImpl.getInstance().read().onDecode();
    }

    @Override
    public void execute() {
        IRImpl.getInstance().read().onExecute();
    }
}
