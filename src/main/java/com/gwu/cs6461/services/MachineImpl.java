package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.fault.IllegalOperationCode;
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
    public void run() throws IllegalOperationCode {
        CPUImpl.getInstance().resume();
    }

    @Override
    public void halt() {
        CPUImpl.getInstance().pause();
    }

    @Override
    public void singleStep() throws IllegalOperationCode {
        CPUImpl.getInstance().pauseAfter(1);
    }

    @Override
    public void ipl() {
        // reset CPU and DRAM
        CPUImpl.getInstance().reset();
        RomLoaderImpl.getInstance().boot();
    }
}
