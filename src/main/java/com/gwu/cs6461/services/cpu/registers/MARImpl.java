package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;

import java.util.Observable;

/**
 * Singleton
 * Memory Address Register
 * It holds the address of active memory location.
 * When CPU wants to store or read data from memory, CPU stores the required address of memory location in MAR.
 */
public class MARImpl extends Observable implements Register<DRAMAddress>{

    private static MARImpl ourInstance = new MARImpl();

    public static MARImpl getInstance() {
        return ourInstance;
    }

    private MARImpl() {

    }

    private DRAMAddress activeAddress = new DRAMAddress();

    @Override
    public void write(DRAMAddress address) {
        activeAddress = address;
        setChanged();
        notifyObservers(address.getDecimalValue());
    }

    @Override
    public DRAMAddress read() {
        return activeAddress;
    }

    @Override
    public void reset() {
        write(new DRAMAddress());
    }
}
