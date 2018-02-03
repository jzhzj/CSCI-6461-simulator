package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.LSInstructionImpl;

/**
 * STX Instruction
 * Store Index Register to Memory. X = 1..3
 */
public class STXImpl extends LSInstructionImpl {

    @Override
    public void onExecute() {
        super.onExecute();
        // Memory(EA) <- c(Xx)
        DRAMImpl.getInstance().write(getEffectiveAddress(), new DRAMDataImpl().setValue(getIdxRegister().read().getDecimalValue()));
    }
}
