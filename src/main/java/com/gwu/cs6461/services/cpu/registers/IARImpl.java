package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * Instruction Address Register
 * a.k.a Program Counter (PC), Instruction Pointer (IP)
 * It holds the address of the next instruction to be fetched and executed.
 * When instruction is fetched, the value of PC is automatically incremented and it points to the address of next instruction
 */
public class IARImpl implements Register<DRAMAddress> {

    private static IARImpl ourInstance = new IARImpl();

    public static IARImpl getInstance() {
        return ourInstance;
    }

    private IARImpl() {

    }

    private DRAMAddress nextInsAddress;

    @Override
    public void write(DRAMAddress address) {
        nextInsAddress = address;
    }

    @Override
    public DRAMAddress read() {
        return nextInsAddress;
    }

    @Override
    public void reset() {
        write(null);
    }
}
