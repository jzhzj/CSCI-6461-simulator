package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;

import java.util.Observable;

/**
 * Singleton
 * Index Register 3
 * Index Registers are used for data movement.
 */

public class IDXR3Impl extends Observable implements Register<DRAMAddress> {

    private static IDXR3Impl ourInstance = new IDXR3Impl();

    public static IDXR3Impl getInstance() {
        return ourInstance;
    }

    private IDXR3Impl() {

    }

    private DRAMAddress dramAddress;

    @Override
    public void write(DRAMAddress data) {
        dramAddress = data;
        setChanged();
        notifyObservers();
    }

    @Override
    public DRAMAddress read() {
        return dramAddress;
    }

    @Override
    public void reset() {
        write(new DRAMAddress().setValue(0));
    }
}
