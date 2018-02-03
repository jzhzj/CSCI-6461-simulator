package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.romloader.RomLoaderImpl;

/**
 * Singleton
 * Machine
 */
public class MachineImpl implements Machine{

    private static MachineImpl ourInstance = new MachineImpl();

    public static MachineImpl getInstance() {
        return ourInstance;
    }

    private MachineImpl() {

    }

    @Override
    public void run() {

    }

    @Override
    public void halt() {

    }

    @Override
    public void singleStep() {

    }

    @Override
    public void ipl() {
        // reset CPU and DRAM
        CPUImpl.getInstance().reset();
        DRAMImpl.getInstance().reset();

        RomLoaderImpl.getInstance().load();
    }
}
