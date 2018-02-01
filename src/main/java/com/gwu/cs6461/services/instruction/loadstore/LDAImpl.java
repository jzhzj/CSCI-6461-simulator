package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * LDA Instruction
 */
public class LDAImpl implements Instruction  {

    private DRAMData instruction;

    @Override
    public void onExecute() {
        System.out.println("111");
    }

    @Override
    public LDAImpl fromDRAMData(DRAMData data) {
        instruction = data;
        return this;
    }

    @Override
    public DRAMData toDRAMData() {
        return instruction;
    }
}
