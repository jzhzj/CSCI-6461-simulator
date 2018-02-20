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
public class SIRImpl extends ALImpl {
    private int immedFieldValue;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            DRAMData data = gpRegister.read();
            //r <- c(r) - Immed
            if (getImmed() == 0) {

            } else if (gpRegister.read().getDecimalValue() == 0) {
                GPR1Impl.getInstance().write(new DRAMDataImpl().setDecimalValue(-getImmed()));
            } else {
                gpRegister.write(ALUImpl.getInstance().subtract(data, getImmed()));
            }


        };
        return task;
    }


    private int getImmed() {
        String instructionBinary = toDRAMData().getBinaryValue();
        immedFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
        return immedFieldValue;
    }
}
