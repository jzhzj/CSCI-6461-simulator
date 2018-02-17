package com.gwu.cs6461.services.instruction.transfer;


import com.gwu.cs6461.services.cpu.registers.CCRImpl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;

/**
 * JCC Instruction
 * TODO to be implemented
 */
public class JCCImpl extends TransferImpl {

    @Override
    public Runnable onDecode() {
        Runnable task = () -> {
            //TODO complete the condition argument after realizing the CCRImpl
            if (CCRImpl.getInstance().read().getId().getDecimalValue() == 1) {
                IARImpl.getInstance().write(new DRAMAddress().setDecimalValue(effectiveAddress.getDecimalValue()));
            }
        };
        return task;
    }
}
