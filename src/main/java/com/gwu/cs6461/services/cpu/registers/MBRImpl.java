package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;

/**
 * Singleton
 * Memory Buffer Register
 * It holds the contents of memory location read from or written to the memory
 */
public class MBRImpl implements Register<DRAMData> {

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
    }

    @Override
    public DRAMData read() {
        return memoryBuffer;
    }

    @Override
    public void reset() {
        write(null);
    }
}
