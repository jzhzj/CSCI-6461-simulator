package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * Memory Address Register
 * It holds the address of active memory location.
 * When CPU wants to store or read data from memory, CPU stores the required address of memory location in MAR.
 */
public class MARImpl implements Register<DRAMAddress>{

    private DRAMAddress activeAddress;

    @Override
    public void write(DRAMAddress address) {
        activeAddress = address;
    }

    @Override
    public DRAMAddress read() {
        return activeAddress;
    }
}
