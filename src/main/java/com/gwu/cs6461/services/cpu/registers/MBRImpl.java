package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;

/**
 * Memory Buffer Register
 * It holds the contents of memory location read from or written to the memory
 */
public class MBRImpl implements Register<DRAMData> {

    private DRAMData memoryBuffer;

    @Override
    public void write(DRAMData data) {
        memoryBuffer = data;
    }

    @Override
    public DRAMData read() {
        return memoryBuffer;
    }
}
