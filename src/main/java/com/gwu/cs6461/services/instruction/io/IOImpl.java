package com.gwu.cs6461.services.instruction.io;

import com.gwu.cs6461.services.cpu.registers.GPR0Impl;
import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.device.Device;
import com.gwu.cs6461.services.device.Keyboard;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.InstructionImpl;

/**
 * IO Instruction
 * super class of all IO instructions
 * TODO to be implemented
 */
public class IOImpl extends InstructionImpl {

    Register<DRAMData> gpRegister;
    Device<DRAMData> ioDevice;

    @Override
    public Runnable onDecode() {
        Runnable task = () -> {

            gpRegister = GPR0Impl.getInstance();
            ioDevice = Keyboard.getInstance();
        };
        return task;
    }
}
