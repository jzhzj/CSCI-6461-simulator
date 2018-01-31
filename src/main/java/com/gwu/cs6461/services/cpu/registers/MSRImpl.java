package com.gwu.cs6461.services.cpu.registers;

/**
 * Singleton
 * Machine Status Register: certain bits record the status of the health of the machine
 * 16 bits
 * TODO to be implemented
 */
public class MSRImpl implements Register{

    private static MSRImpl ourInstance = new MSRImpl();

    public static MSRImpl getInstance() {
        return ourInstance;
    }

    private MSRImpl() {

    }

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
