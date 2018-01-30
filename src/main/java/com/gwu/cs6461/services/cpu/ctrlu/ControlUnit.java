package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Defines what control unit does: decode and fetch instructions
 * TODO need more detailed design.
 */
public interface ControlUnit {

    @ClockCycle(count = ClockCycle.FETCH)
    Instruction fetch();

    @ClockCycle(count = ClockCycle.DECODE)
    void decode(Instruction instruction);

    @ClockCycle(count = ClockCycle.EXECUTE)
    void execute();
}
