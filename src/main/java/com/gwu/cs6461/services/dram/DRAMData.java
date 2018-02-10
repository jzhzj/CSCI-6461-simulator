package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.services.fault.IllegalOperationCode;
import com.gwu.cs6461.services.instruction.Instruction;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what memory data does
 */
public interface DRAMData extends Binary{
    /**
     * Convert data to Instruction type
     * @return an Instruction
     * @throws IllegalOperationCode not any data can be converted, given an illegal op code, this machine fault will be thrown
     */
    Instruction toInstruction() throws IllegalOperationCode;
}
