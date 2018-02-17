package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * JZ Instruction
 */
public class JZImpl extends TransferImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            if (gpRegister.read().getDecimalValue() == 0) {
                IARImpl.getInstance().write(new DRAMAddress().setDecimalValue(effectiveAddress.getDecimalValue()));
            }
        };
        return task;
    }
}
