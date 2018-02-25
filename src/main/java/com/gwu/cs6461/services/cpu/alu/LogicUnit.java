package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.util.Binary;

/**
 * Defines what Logic Unit does
 */
public interface LogicUnit {
    Binary and(Binary a, Binary b);

    Binary or(Binary a, Binary b);

    Binary not(Binary a);

    void test(Binary a, Binary b);

    Binary arithmeticShiftR(Binary a, int count);

    Binary logicalShiftL(Binary a, int count);

    Binary logicalShiftR(Binary a, int count);

    Binary logicalRotateL(Binary a, int count);

    Binary logicalRotateR(Binary a, int count);

}
