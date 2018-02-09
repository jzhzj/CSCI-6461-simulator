package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.services.fault.IllegalOperationCode;
import com.gwu.cs6461.services.instruction.Instruction;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what memory data does
 */
public interface DRAMData extends Binary{
    Instruction toInstruction() throws IllegalOperationCode;
}
