package com.gwu.cs6461.services.cpu.ctrlu;


import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Defines what control unit does: schedule instructions as tasks
 */
public interface ControlUnit {

    void scheduleTask(Instruction instruction);

}
