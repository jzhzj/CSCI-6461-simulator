package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * Singleton
 * Index Register 2
 * Index Registers are used for data movement.
 * TODO to be implemented
 */
public class IDXR2Impl implements Register<DRAMAddress> {

    private static IDXR2Impl ourInstance = new IDXR2Impl();

    public static IDXR2Impl getInstance() {
        return ourInstance;
    }

    private IDXR2Impl() {

    }

    @Override
    public void write(DRAMAddress address) {

    }

    @Override
    public DRAMAddress read() {
        return null;
    }

    @Override
    public void reset() {
        write(null);
    }
}
