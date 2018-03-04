package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.dram.DRAMData;

/**
 * SRC Instruction
 * Shift Register by Count
 */
public class SRCImpl extends arithRCImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            if (isLeft) {
                gpRegister.write((DRAMData) ALUImpl.getInstance().logicalShiftL(gpRegister.read(), count));
            } else {
                if (isLogical) {
                    gpRegister.write((DRAMData) ALUImpl.getInstance().logicalShiftR(gpRegister.read(), count));
                } else {
                    gpRegister.write((DRAMData) ALUImpl.getInstance().arithmeticShiftR(gpRegister.read(), count));
                }
            }
        };
        return task;
    }
}
