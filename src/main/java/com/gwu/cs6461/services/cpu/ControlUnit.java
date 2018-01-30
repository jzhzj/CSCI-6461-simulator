package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Defines what control unit does: decode and fetch instructions
 * TODO need more detailed design.
 */
public interface ControlUnit {

    @ClockCycle(count = 1)
    Instruction fetch();

    @ClockCycle(count = 2)
    void decode(Instruction instruction);

    @ClockCycle(count = 3)
    void execute();
}
