package com.gwu.cs6461.services.instruction.miscellaneous;

import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.instruction.InstructionImpl;

/**
 * Halt Instruction
 */
public class HaltImpl extends InstructionImpl {

    @Override
    public Runnable onDecode() {
        // do nothing
        Runnable task = () -> {

        };
        return task;
    }

    @Override
    public Runnable onExecute() {
        // pause CPU
        Runnable task = () -> {
            CPUImpl.getInstance().pause();
        };
        return task;
    }
}
