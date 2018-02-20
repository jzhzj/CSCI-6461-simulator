package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what Logic Unit does
 * TODO need more detailed design.
 */
public interface LogicUnit {
    DRAMData and(DRAMData a, DRAMData b);
    DRAMData or(DRAMData a, DRAMData b);
    DRAMData not(DRAMData a);
    DRAMData arithmeticShiftL(DRAMData a);
    DRAMData arithmeticShiftR(DRAMData a);
    DRAMData logicalShiftL(DRAMData a);
    DRAMData logicalShiftR(DRAMData a);
    DRAMData logicalRotateL(DRAMData a);
    DRAMData logicalRotateR(DRAMData a);

}
