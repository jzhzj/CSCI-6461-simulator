package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;

/**
 * JZ Instruction
 * Jump If Zero
 */
public class JZImpl extends TransferImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            if (gpRegister.read().getDecimalValue() == 0) {
                //PC <- EA
                IARImpl.getInstance().write(effectiveAddress);
            }
        };
        return task;
    }
}
