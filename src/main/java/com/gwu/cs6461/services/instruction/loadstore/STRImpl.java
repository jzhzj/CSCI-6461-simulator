package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * STR Instruction
 * Store Register To Memory, r = 0..3
 */
public class STRImpl extends LSImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            // c(r)
            DRAMData dramData = gpRegister.read();
            // MBR <- c(r)
            MBRImpl.getInstance().write(dramData);
            // Memory(EA) <− MBR
            DRAMImpl.getInstance().write(effectiveAddress, MBRImpl.getInstance().read());
        };
        return executeTask;

    }
}
