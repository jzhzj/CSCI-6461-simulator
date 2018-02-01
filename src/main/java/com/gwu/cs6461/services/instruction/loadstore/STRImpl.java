package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * STR Instruction
 */
public class STRImpl implements Instruction  {

    private DRAMData instruction;

    @Override
    public void onExecute() {

    }

    @Override
    public STRImpl fromDRAMData(DRAMData data) {
        instruction = data;
        return this;
    }

    @Override
    public DRAMData toDRAMData() {
        return instruction;
    }
}
