package com.gwu.cs6461.services.cpu.registers;

/**
 * Singleton
 * Index Register 1
 * Index Registers are used for data movement.
 * TODO to be implemented
 */
public class IDXR1Impl implements Register<Object> {
    @Override
    public void write(Object data) {

    }

    @Override
    public Object read() {
        return null;
    }

    @Override
    public void reset() {
        write(null);
    }
}
