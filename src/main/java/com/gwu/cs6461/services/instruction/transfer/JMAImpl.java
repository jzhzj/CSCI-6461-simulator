package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;

/**
 * JMA Instruction
 * Unconditional Jump To Address
 */
public class JMAImpl extends TransferImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //PC <- EA
            IARImpl.getInstance().write(effectiveAddress);
        };
        return task;
    }

}
