package com.gwu.cs6461.services;

import com.gwu.cs6461.services.romloader.RomLoader;
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

    private RomLoader romLoader = RomLoaderImpl.getInstance();

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
        romLoader.load();
    }
}
