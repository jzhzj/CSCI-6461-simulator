package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * ORR Instruction
 * Logical Or of Register and Register
 */
public class ORRImpl extends arithRRImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //Logical Or of Register and Register
            gpRegister.write(ALUImpl.getInstance().or(gpRegister.read(), gpRegister2.read()));
        };
        return task;
    }
}
