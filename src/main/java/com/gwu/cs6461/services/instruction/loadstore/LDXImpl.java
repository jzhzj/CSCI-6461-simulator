package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.sram.SRAMImpl;

/**
 * LDX Instruction
 * Load Index Register from Memory, x = 1..3
 */

public class LDXImpl extends LSImpl {


    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            //  c(EA)
            DRAMData data = SRAMImpl.getInstance().read(effectiveAddress);
            // MBR <- c(EA)
            MBRImpl.getInstance().write(data);
            //  Xx <- MBR
            idxRegister.write(new DRAMAddressImpl().setDecimalValue(MBRImpl.getInstance().read().getDecimalValue()));
        };
        return executeTask;
    }
}
