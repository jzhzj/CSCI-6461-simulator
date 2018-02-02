package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.LSInstruction;

/**
 * LDX Instruction
 * Load Index Register from Memory, x = 1..3
 */

public class LDXImpl extends LSInstruction {


    @Override
    public void onExecute() {
        super.onExecute();

        //  c(EA)
        DRAMData data = DRAMImpl.getInstance().read(getEffectiveAddress());
        //  Xx <- c(EA)
        getIdxRegister().write(new DRAMAddress().setValue(data.getDecimalValue()));
    }
}
