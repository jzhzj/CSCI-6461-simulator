package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * STX Instruction
 * Store Index Register to Memory. X = 1..3
 */
public class STXImpl extends LSImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () ->{
            // c(Xx)
            DRAMData dramData = new DRAMDataImpl().setDecimalValue(getIdxRegister().read().getDecimalValue());
            // MBR <- c(Xx)
            MBRImpl.getInstance().write(dramData);
            // Memory(EA) <- MBR
            DRAMImpl.getInstance().write(getEffectiveAddress(), MBRImpl.getInstance().read());
        };
        return executeTask;
    }
}
