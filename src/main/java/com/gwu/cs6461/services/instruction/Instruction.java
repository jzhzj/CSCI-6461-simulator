package com.gwu.cs6461.services.instruction;


import com.gwu.cs6461.services.dram.DRAMData;

/**
 * Defines what instruction does
 * 16 bits binary
 */
public interface Instruction {
    void onFetch();
    void onDecode();
    void onExecute();
    Instruction fromDRAMData(DRAMData data);
    DRAMData toDRAMData();
}
