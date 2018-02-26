package com.gwu.cs6461.services.instruction.io;


import java.util.concurrent.ExecutionException;

/**
 * IN Instruction
 * Input Character To Register from Device, r = 0..3
 */
public class INImpl extends IOImpl {
    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            try {
                gpRegister.write(ioDevice.read().get());
                ioDevice.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        };
        return task;
    }
}
