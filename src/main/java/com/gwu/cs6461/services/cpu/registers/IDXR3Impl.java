package com.gwu.cs6461.services.cpu.registers;

/**
 * Singleton
 * Index Register 3
 * Index Registers are used for data movement.
 * TODO to be implemented
 */
public class IDXR3Impl implements Register<Object> {
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
