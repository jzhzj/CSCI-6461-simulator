package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Singleton
 * Control Unit: the most important part of CPU
 */
public class ControlUnitImpl implements ControlUnit {

    private static ControlUnitImpl ourInstance = new ControlUnitImpl();

    public static ControlUnitImpl getInstance() {
        return ourInstance;
    }

    private ControlUnitImpl() {

    }


    private synchronized void fetch(Runnable task) {
        // run synchronously in this thread
        task.run();
    }


    private synchronized void decode(Runnable task) {
        // run synchronously in this thread
        task.run();
    }


    private synchronized void execute(Runnable task) {
        // run synchronously in this thread
        task.run();
    }

    @Override
    public void scheduleTask(Instruction instruction) {
        fetch(instruction.onFetch());
        decode(instruction.onDecode());
        execute(instruction.onExecute());
    }
}
