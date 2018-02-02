package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * LDA Instruction
 */
public class LDAImpl implements Instruction  {

    private DRAMData data;

    @Override
    public void onFetch() {

    }

    @Override
    public void onDecode() {

    }

    @Override
    public void onExecute() {
        data.getBinary();
    }

    @Override
    public LDAImpl fromDRAMData(DRAMData data) {
        this.data = data;
        return this;
    }

    @Override
    public DRAMData toDRAMData() {
        return data;
    }
}
