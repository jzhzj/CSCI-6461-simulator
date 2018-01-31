package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.CPUImpl;
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
        CPUImpl.getInstance().run();
    }

    @Override
    public void halt() {
        CPUImpl.getInstance().halt();
    }

    @Override
    public void singleStep() {
        CPUImpl.getInstance().singleStep();
    }

    @Override
    public void ipl() {
        RomLoaderImpl.getInstance().load();
    }
}
