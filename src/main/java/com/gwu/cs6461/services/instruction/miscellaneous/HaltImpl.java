package com.gwu.cs6461.services.instruction.miscellaneous;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * Halt Instruction
 */
public class HaltImpl implements Instruction {

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
    public Instruction fromDRAMData(DRAMData data) {
        return null;
    }

    @Override
    public DRAMData toDRAMData() {
        return null;
    }
}
