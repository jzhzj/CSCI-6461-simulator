package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Defines what control unit does: decode and fetch instructions
 * TODO need more detailed design.
 */
public interface ControlUnit {

    /**
     * Fetch an Instruction from a given memory address
     * @param address memory address
     * @return instruction
     */
    void fetch(DRAMAddress address);

    void decode(Instruction instruction);

    void execute(Instruction instruction);

}
