package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.LSInstructionImpl;

/**
 * STR Instruction
 * Store Register To Memory, r = 0..3
 */
public class STRImpl extends LSInstructionImpl {

    @Override
    public void onExecute() {
        super.onExecute();
        // Memory(EA) <− c(r)
        DRAMImpl.getInstance().write(getEffectiveAddress(), getGpRegister().read());
    }
}
