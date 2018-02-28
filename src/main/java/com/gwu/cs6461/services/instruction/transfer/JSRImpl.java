package com.gwu.cs6461.services.instruction.transfer;


import com.gwu.cs6461.services.cpu.registers.GPR3Impl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

/**
 * JSR Instruction
 * Jump and Save Return Address
 */
public class JSRImpl extends TransferImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //R3 <- PC+1;
            GPR3Impl.getInstance().write(new DRAMDataImpl().setDecimalValue(IARImpl.getInstance().read().getDecimalValue()));
            //PC <- EA ;
            IARImpl.getInstance().write(effectiveAddress);
        };
        return task;
    }
}
