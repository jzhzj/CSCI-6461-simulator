package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * LDR Instruction
 * Load Register From Memory based on Effective address, r = 0..3
 */
public class LDRImpl extends LSImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            // c(EA)
            DRAMData dataCEA = DRAMImpl.getInstance().read(effectiveAddress);
            // MBR <- c(EA)
            MBRImpl.getInstance().write(dataCEA);
            // r <− MBR
            gpRegister.write(MBRImpl.getInstance().read());
        };
        return executeTask;
    }
}
