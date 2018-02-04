package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

import java.util.Observable;

/**
 * Singleton
 * Memory Buffer Register
 * It holds the contents of memory location read from or written to the memory
 */
public class MBRImpl extends Observable implements Register<DRAMData> {

    private static MBRImpl ourInstance = new MBRImpl();

    public static MBRImpl getInstance() {
        return ourInstance;
    }

    private MBRImpl() {

    }

    private DRAMData memoryBuffer;

    @Override
    public void write(DRAMData data) {
        memoryBuffer = data;
        setChanged();
        notifyObservers();
    }

    @Override
    public DRAMData read() {
        return memoryBuffer;
    }

    @Override
    public void reset() {
        write(new DRAMDataImpl().setValue(0));
    }
}
