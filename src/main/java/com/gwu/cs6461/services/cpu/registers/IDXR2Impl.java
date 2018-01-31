package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.util.Binary;

/**
 * Singleton
 * Index Register 2
 * Index Registers are used for data movement.
 * TODO to be implemented
 */
public class IDXR2Impl implements Register<Binary> {

    private static IDXR2Impl ourInstance = new IDXR2Impl();

    public static IDXR2Impl getInstance() {
        return ourInstance;
    }

    private IDXR2Impl() {

    }

    @Override
    public void write(Binary data) {

    }

    @Override
    public Binary read() {
        return null;
    }

    @Override
    public void reset() {
        write(null);
    }
}
