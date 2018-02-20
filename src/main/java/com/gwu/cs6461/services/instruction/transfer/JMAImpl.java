package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * JMA Instruction
 */
public class JMAImpl extends TransferImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //PC <- EA
            IARImpl.getInstance().write(new DRAMAddress().setDecimalValue(effectiveAddress.getDecimalValue()));
        };
        return task;
    }

}
