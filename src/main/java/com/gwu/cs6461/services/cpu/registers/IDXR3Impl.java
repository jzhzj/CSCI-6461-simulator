package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.util.Binary;

/**
 * Singleton
 * Index Register 3
 * Index Registers are used for data movement.
 * TODO to be implemented
 */
public class IDXR3Impl implements Register<Binary> {

    private static IDXR3Impl ourInstance = new IDXR3Impl();

    public static IDXR3Impl getInstance() {
        return ourInstance;
    }

    private IDXR3Impl() {

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
