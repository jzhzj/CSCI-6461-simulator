package com.gwu.cs6461.services.instruction.loadstore;


import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.instruction.LSInstructionImpl;

/**
 * LDA Instruction
 * Load Register with Address, r = 0..3
 */
public class LDAImpl extends LSInstructionImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            //  r <− EA
            getGpRegister().write(new DRAMDataImpl().setValue(getEffectiveAddress().getDecimalValue()));
        };
        return executeTask;
    }
}
