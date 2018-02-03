package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.util.Binary;

/**
 * Singleton
 * Index Register 1
 * Index Registers are used for data movement.
 */

public class IDXR1Impl implements Register<DRAMAddress> {

    private static IDXR1Impl ourInstance = new IDXR1Impl();

    public static IDXR1Impl getInstance() {
        return ourInstance;
    }

    private IDXR1Impl() {

    }

    private DRAMAddress dramAddress;

    @Override
    public void write(DRAMAddress address) {
        dramAddress = address;
    }

    @Override
    public DRAMAddress read() {
        return dramAddress;
    }

    @Override
    public void reset() {
        write(null);
    }
}
