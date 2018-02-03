package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.cpu.registers.MARImpl;

/**
 * Singleton
 * CPU
 */
public class CPUImpl implements CPU{

    private static CPUImpl ourInstance = new CPUImpl();

    public static CPUImpl getInstance() {
        return ourInstance;
    }

    private CPUImpl() {

    }

    @Override
    public void reset() {
        // TODO reset all registers
        MARImpl.getInstance().reset();
    }
}
