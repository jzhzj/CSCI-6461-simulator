package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what Logic Unit does
 * TODO need more detailed design.
 */
public interface LogicUnit {
    Binary and(Binary a, Binary b);
    Binary or(Binary a, Binary b);
    Binary not(Binary a);
    Binary arithmeticShiftL(Binary a);
    Binary arithmeticShiftR(Binary a);
    Binary logicalShiftL(Binary a);
    Binary logicalShiftR(Binary a);
    Binary logicalRotateL(Binary a);
    Binary logicalRotateR(Binary a);

}
