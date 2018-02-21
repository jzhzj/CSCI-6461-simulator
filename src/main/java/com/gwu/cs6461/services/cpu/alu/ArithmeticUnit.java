package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.util.Binary;

/**
 * Defines what Arithmetic Unit does
 * ALU is responsible for handling all numerical operations.
 * TODO need more detailed design.
 */
public interface ArithmeticUnit {

    /**
     * a and b are summed
     *
     * @param a
     * @param b
     * @return
     */
    DRAMData add(DRAMData a, DRAMData b);


    /**
     * b is subtracted from a
     *
     * @param a
     * @param b
     * @return
     */
    DRAMData subtract(DRAMData a, DRAMData b);


    /**
     * a and b are summed
     *
     * @param a
     * @param b
     * @return
     */
    DRAMData add(DRAMData a, int b);


    /**
     * b is subtracted from a
     *
     * @param a
     * @param b
     * @return
     */
    DRAMData subtract(DRAMData a, int b);

    /**
     * a and b are summed
     *
     * @param a
     * @param b
     * @return
     */
    DRAMData[] multiply(DRAMData a, DRAMData b);


    /**
     * b is subtracted from a
     *
     * @param a
     * @param b
     * @return
     */
    DRAMData[] divide(DRAMData a, DRAMData b);

}
