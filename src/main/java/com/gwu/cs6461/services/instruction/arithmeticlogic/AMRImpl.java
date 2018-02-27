package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.sram.SRAMImpl;

/**
 * AMR Instruction
 * Add Memory To Register, r = 0..3
 */
public class AMRImpl extends arithRXAImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //r <- c(r) + c(EA)
            gpRegister.write((DRAMData) ALUImpl.getInstance().add(gpRegister.read(), SRAMImpl.getInstance().read(effectiveAddress)));
        };
        return task;
    }
}
