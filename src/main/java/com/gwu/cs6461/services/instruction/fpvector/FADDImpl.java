package com.gwu.cs6461.services.instruction.fpvector;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.Instruction;

/**
 * FADD Instruction
 */
public class FADDImpl implements Instruction {

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