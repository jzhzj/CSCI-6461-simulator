package com.gwu.cs6461.services.instruction.transfer;

import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

/**
 * SOB Instruction
 * Subtract One and Branch
 */
public class SOBImpl extends TransferImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            DRAMData data = gpRegister.read();
            //r <- c(r) – 1
            gpRegister.write((DRAMData) ALUImpl.getInstance().subtract(gpRegister.read(), 1));
            //If c(r) > 0,  PC <- EA;
            if (gpRegister.read().getDecimalValue() > 0) {
                IARImpl.getInstance().write(new DRAMAddress().setDecimalValue(effectiveAddress.getDecimalValue()));
            }
        };
        return task;
    }

}
