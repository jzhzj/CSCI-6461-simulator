package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * AND Instruction
 * Logical And of Register and Register
 */
public class ANDImpl extends arithRRImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //c(rx) <- c(rx) AND c(ry)
            gpRegister.write((DRAMData) ALUImpl.getInstance().and(gpRegister.read(), gpRegister2.read()));
        };
        return task;
    }
}
