package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * STR Instruction
 * Store Register To Memory, r = 0..3
 */
public class STRImpl extends LSImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () ->{
            // Memory(EA) <− c(r)
            DRAMImpl.getInstance().write(getEffectiveAddress(), getGpRegister().read());
        };
        return executeTask;

    }
}
