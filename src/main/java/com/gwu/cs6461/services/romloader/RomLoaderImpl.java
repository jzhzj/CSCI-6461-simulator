package com.gwu.cs6461.services.romloader;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * Singleton
 * Rom Loader
 */
public class RomLoaderImpl implements RomLoader{

    private static RomLoaderImpl ourInstance = new RomLoaderImpl();

    public static RomLoaderImpl getInstance() {
        return ourInstance;
    }

    private RomLoaderImpl() {

    }

    @Override
    public void load() {
        DRAMImpl.getInstance().init();

        // set PC to the 1st instruction to be executed
        IARImpl.getInstance().reset();

        // TODO load some customized instructions into memory (9) here


        // ok, loader's job is done.
    }
}
