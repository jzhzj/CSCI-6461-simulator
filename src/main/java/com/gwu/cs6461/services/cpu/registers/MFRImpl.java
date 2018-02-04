package com.gwu.cs6461.services.cpu.registers;

import java.util.Observable;

/**
 * Singleton
 * Machine Fault Register: contains the ID code if a machine fault after it occurs
 * 4 bits
 * TODO to be implemented
 */
public class MFRImpl extends Observable implements Register {

    private static MFRImpl ourInstance = new MFRImpl();

    public static MFRImpl getInstance() {
        return ourInstance;
    }

    private MFRImpl() {

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
