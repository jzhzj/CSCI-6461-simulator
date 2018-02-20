package com.gwu.cs6461.services.instruction.arithmeticlogic;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * SMR Instruction
 * Subtract Memory From Register, r = 0..3
 * TODO to be implemented
 */
public class SMRImpl extends ALImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //c(r)
            DRAMData dataGpR = gpRegister.read();
            //c(EA)
            DRAMData dataCEA = DRAMImpl.getInstance().read(effectiveAddress);
            //r <- c(r) - c(EA)
            gpRegister.write(new DRAMDataImpl().setDecimalValue(dataGpR.getDecimalValue() - dataCEA.getDecimalValue()));
        };
        return task;
    }
}
