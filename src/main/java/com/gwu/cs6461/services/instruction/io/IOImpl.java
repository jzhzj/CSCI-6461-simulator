package com.gwu.cs6461.services.instruction.io;

import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.InstructionImpl;

/**
 * IO Instruction
 * super class of all IO instructions
 * TODO to be implemented
 */
public class IOImpl extends InstructionImpl {

    Register<DRAMData> gpRegister;

    @Override
    public Runnable onDecode() {
        Runnable task = () -> {

        };
        return task;
    }
}
