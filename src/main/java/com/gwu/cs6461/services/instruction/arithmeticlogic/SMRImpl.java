package com.gwu.cs6461.services.instruction.arithmeticlogic;

import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * SMR Instruction
 * Subtract Memory From Register, r = 0..3
 */
public class SMRImpl extends ALImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //r <- c(r) - c(EA)
            gpRegister.write(ALUImpl.getInstance().subtract(gpRegister.read(), DRAMImpl.getInstance().read(effectiveAddress)));
        };
        return task;
    }
}
