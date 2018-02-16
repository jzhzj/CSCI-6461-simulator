package com.gwu.cs6461.services.sram;

/**
 * A fully associative, unified cache.
 * sits between memory and the rest of the processor.
 * A vector having a format similar to that described in the lecture notes.
 * 16 cache lines
 * TODO to be implemented
 */
public class SRAMImpl implements SRAM {

    private static SRAMImpl ourInstance = new SRAMImpl();

    public static SRAMImpl getInstance() {
        return ourInstance;
    }

    private SRAMImpl() {

    }


    @Override
    public void read() {

    }

    @Override
    public void write() {

    }
}
