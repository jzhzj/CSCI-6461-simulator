package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * AIR Instruction
 */
public class AIRImpl extends ALImpl {
    private int immedFieldValue;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            DRAMData data = gpRegister.read();
            //r <- c(r) + Immed
            gpRegister.write(new DRAMDataImpl().setDecimalValue(data.getDecimalValue()+getImmed()));
        };
        return task;
    }

    private int getImmed() {
        String instructionBinary = toDRAMData().getBinaryValue();
        immedFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
        return immedFieldValue;
    }
}
