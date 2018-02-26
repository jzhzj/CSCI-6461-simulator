package com.gwu.cs6461.services.instruction.io;


/**
 * IN Instruction
 * Input Character To Register from Device, r = 0..3
 */
public class INImpl extends IOImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            gpRegister.write(ioDevice.read());
        };
        return task;
    }
}
