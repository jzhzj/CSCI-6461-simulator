package com.gwu.cs6461.services.instruction.transfer;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.GPR3Impl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMData;

/**
 * JSR Instruction
 * Jump and Save Return Address
 * TODO to be implemented
 */
public class JSRImpl extends TransferImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //R3 <- PC+1;
            GPR3Impl.getInstance().write((DRAMData) new DRAMAddressImpl().setDecimalValue(ALUImpl.getInstance().add(IARImpl.getInstance().read(), 1).getDecimalValue()));
            //PC <- EA ;
            IARImpl.getInstance().write(effectiveAddress);
        };
        return task;
    }
}
