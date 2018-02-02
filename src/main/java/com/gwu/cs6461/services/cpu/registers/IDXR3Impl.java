package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * Singleton
 * Index Register 3
 * Index Registers are used for data movement.
 * TODO to be implemented
 */
public class IDXR3Impl implements Register<DRAMAddress> {

    private static IDXR3Impl ourInstance = new IDXR3Impl();

    public static IDXR3Impl getInstance() {
        return ourInstance;
    }

    private IDXR3Impl() {

    }

    @Override
    public void write(DRAMAddress data) {

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
