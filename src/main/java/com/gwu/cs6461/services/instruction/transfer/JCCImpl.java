package com.gwu.cs6461.services.instruction.transfer;


import com.gwu.cs6461.services.cpu.alu.cc.ConditionCode;
import com.gwu.cs6461.services.cpu.registers.CCRImpl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;

/**
 * JCC Instruction
 * Jump If Condition Code
 */
public class JCCImpl extends TransferImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {

            if (CCRImpl.getInstance().read().getBit(ConditionCode.Type.UNDER_FLOW)) {
                //PC <- EA
                IARImpl.getInstance().write(effectiveAddress);
            }
        };
        return task;
    }
}
