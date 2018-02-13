package com.gwu.cs6461.services.instruction.loadstore;


import com.gwu.cs6461.services.dram.DRAMDataImpl;

/**
 * LDA Instruction
 * Load Register with Effective Address, r = 0..3
 */
public class LDAImpl extends LSImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            //  r <− EA
            gpRegister.write(new DRAMDataImpl().setDecimalValue(effectiveAddress.getDecimalValue()));
        };
        return executeTask;
    }
}
