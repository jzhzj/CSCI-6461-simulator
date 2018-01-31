package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;

/**
 * Singleton
 * Instruction Register
 * It holds the current instruction that is being executed
 */
public class IRImpl implements Register<DRAMData>{

    private static IRImpl ourInstance = new IRImpl();

    public static IRImpl getInstance() {
        return ourInstance;
    }

    private IRImpl() {

    }

    private DRAMData currentIns;

    @Override
    public void write(DRAMData data) {
        currentIns = data;
    }

    @Override
    public DRAMData read() {
        return currentIns;
    }

    @Override
    public void reset() {
        write(null);
    }
}
