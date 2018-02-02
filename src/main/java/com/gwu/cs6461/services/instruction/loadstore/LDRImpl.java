package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * LDR Instruction
 */
public class LDRImpl implements Instruction {

    private DRAMData instruction;

    @Override
    public void onFetch() {

    }

    @Override
    public void onDecode() {

    }

    @Override
    public void onExecute() {

    }

    @Override
    public LDRImpl fromDRAMData(DRAMData data) {
        instruction = data;
        return this;
    }

    @Override
    public DRAMData toDRAMData() {
        return instruction;
    }
}
