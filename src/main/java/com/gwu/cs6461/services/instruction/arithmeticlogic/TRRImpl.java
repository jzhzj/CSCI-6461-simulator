package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;

/**
 * TRR Instruction
 * Test the Equality of Register and Register
 */
public class TRRImpl extends arithRRImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //Test the Equality of Register and Register
            ALUImpl.getInstance().test(gpRegister.read(), gpRegister2.read());
        };
        return task;
    }
}
