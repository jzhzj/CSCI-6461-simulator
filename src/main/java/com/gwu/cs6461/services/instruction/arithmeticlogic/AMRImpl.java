package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 * AMR Instruction
 * Add Memory To Register, r = 0..3
 */
public class AMRImpl extends ALImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //c(r)
            DRAMData dataGpR = gpRegister.read();
            //c(EA)
            DRAMData dataCEA = DRAMImpl.getInstance().read(effectiveAddress);
            //r <- c(r) + c(EA)
            gpRegister.write(ALUImpl.getInstance().add(dataGpR, dataCEA));
        };
        return task;
    }
}
