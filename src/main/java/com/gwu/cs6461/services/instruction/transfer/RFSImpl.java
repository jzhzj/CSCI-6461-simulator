package com.gwu.cs6461.services.instruction.transfer;


import com.gwu.cs6461.services.cpu.registers.GPR0Impl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * RFS Instruction

 */
public class RFSImpl extends TransferImpl {
    private int immedFieldValue;
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            DRAMData data = gpRegister.read();
            GPR0Impl.getInstance().write(new DRAMDataImpl().setDecimalValue(getImmed()));

        };
        return task;
    }

    private int getImmed() {
        String instructionBinary = toDRAMData().getBinaryValue();
        immedFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
        return immedFieldValue;
    }

}
