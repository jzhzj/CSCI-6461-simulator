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
        Thread fetchThread = new Thread(task);
        fetchThread.start();
        try {
            fetchThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private synchronized void decode(Runnable task) {
        Thread decodeThread = new Thread(task);
        decodeThread.start();
        try {
            decodeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private synchronized void execute(Runnable task) {
        Thread executeThread = new Thread(task);
        executeThread.start();
        try {
            executeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scheduleTask(Instruction instruction) {
        fetch(instruction.onFetch());
        decode(instruction.onDecode());
        execute(instruction.onExecute());
    }
}
