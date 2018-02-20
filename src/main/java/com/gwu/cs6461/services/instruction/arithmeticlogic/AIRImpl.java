package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALU;
import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * AIR Instruction
 * Add  Immediate to Register, r = 0..3
 */
public class AIRImpl extends ALImpl {
    private int immedFieldValue;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //r <- c(r) + Immed
            gpRegister.write(ALUImpl.getInstance().add(gpRegister.read(), getImmed()));
        };
        return task;
    }

    private int getImmed() {
        String instructionBinary = toDRAMData().getBinaryValue();
        immedFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
        return immedFieldValue;
    }
}
