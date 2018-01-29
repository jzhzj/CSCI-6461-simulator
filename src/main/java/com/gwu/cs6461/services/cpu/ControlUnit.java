package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Defines what control unit does: decode and fetch instructions
 * TODO need more detailed design.
 */
public interface ControlUnit {

    Instruction fetch();
    void decode(Instruction instruction);
    void execute();
}
