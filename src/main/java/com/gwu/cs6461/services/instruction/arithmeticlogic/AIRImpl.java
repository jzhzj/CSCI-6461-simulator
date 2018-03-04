package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import org.apache.commons.lang3.StringUtils;

/**
 * AIR Instruction
 * Add  Immediate to Register, r = 0..3
 */
public class AIRImpl extends arithRXAImpl {
    private int immedFieldValue;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            getImmed();
            //r <- c(r) + Immed
            gpRegister.write((DRAMData) ALUImpl.getInstance().add(gpRegister.read(), immedFieldValue));
        };
        return task;
    }

    private void getImmed() {
        String instructionBinary = toDRAMData().getBinaryValue();
        immedFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
    }
}
