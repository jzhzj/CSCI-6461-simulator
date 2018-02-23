package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;

/**
 * NOT Instruction
 * Logical Not of Register To Register
 */
public class NOTImpl extends arithRRImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //c(rx) <- NOT c(rx)
            gpRegister.write(ALUImpl.getInstance().not(gpRegister.read()));
        };
        return task;
    }
}
