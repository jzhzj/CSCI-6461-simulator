package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;

/**
 * JGE Instruction
 * Jump Greater Than or Equal To
 */
public class JGEImpl extends TransferImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            if (gpRegister.read().getDecimalValue() >= 0) {
                //PC <- EA
                IARImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(effectiveAddress.getDecimalValue()));
            }
        };
        return task;
    }
}
