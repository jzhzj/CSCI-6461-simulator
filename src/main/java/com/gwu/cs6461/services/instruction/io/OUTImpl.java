package com.gwu.cs6461.services.instruction.io;


/**
 * OUT Instruction
 * Output Character to Device from Register, r = 0..3
 */
public class OUTImpl extends IOImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            ioDevice.write(gpRegister.read());
        };
        return task;
    }
}
