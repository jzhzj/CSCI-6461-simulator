package com.gwu.cs6461.services.instruction.loadstore;

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
            // Memory(EA) <- c(Xx)
            DRAMImpl.getInstance().write(getEffectiveAddress(), new DRAMDataImpl().setDecimalValue(getIdxRegister().read().getDecimalValue()));
        };
        return executeTask;
    }
}
