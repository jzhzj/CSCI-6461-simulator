package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.GPR1Impl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * SIR Instruction
 * Subtract  Immediate  from Register, r = 0..3
 */
public class SIRImpl extends arithRXAImpl {
    private int immedFieldValue;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            getImmed();
            //r <- c(r) - Immed
            gpRegister.write(ALUImpl.getInstance().subtract(gpRegister.read(), immedFieldValue));
        };
        return task;
    }


    private void getImmed() {
        String instructionBinary = toDRAMData().getBinaryValue();
        immedFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
    }
}
