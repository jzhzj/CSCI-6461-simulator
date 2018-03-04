package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;

/**
 * RRC Instruction
 * Rotate Register by Count
 */
public class RRCImpl extends arithRCImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            if (isLeft) {
                gpRegister.write((DRAMData) ALUImpl.getInstance().logicalRotateL(gpRegister.read(), count));
            } else {
                gpRegister.write((DRAMData) ALUImpl.getInstance().logicalRotateR(gpRegister.read(), count));
            }
        };
        return task;
    }
}
