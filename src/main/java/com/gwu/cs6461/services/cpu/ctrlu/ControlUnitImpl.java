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

    @Override
    public void scheduleTask(Instruction instruction) {
        // execute instructions 1 by 1 synchronously
        instruction.onFetch().run();
        instruction.onDecode().run();
        instruction.onExecute().run();
    }
}
