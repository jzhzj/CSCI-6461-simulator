package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.LSInstructionImpl;

/**
 * LDX Instruction
 * Load Index Register from Memory, x = 1..3
 */

public class LDXImpl extends LSInstructionImpl {


    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            //  c(EA)
            DRAMData data = DRAMImpl.getInstance().read(getEffectiveAddress());
            //  Xx <- c(EA)
            getIdxRegister().write(new DRAMAddress().setValue(data.getDecimalValue()));
        };
        return executeTask;
    }
}
