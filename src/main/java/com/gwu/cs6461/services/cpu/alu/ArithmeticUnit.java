package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.util.Binary;

/**
 * Defines what Arithmetic Unit does
 * ALU is responsible for handling all numerical operations.
 */
public interface ArithmeticUnit {

    /**
     * a and b are summed
     *
     * @param a
     * @param b
     * @return
     */
    Binary add(Binary a, Binary b);


    /**
     * b is subtracted from a
     *
     * @param a
     * @param b
     * @return
     */
    Binary subtract(Binary a, Binary b);


    /**
     * a and b are summed
     *
     * @param a
     * @param b
     * @return
     */
    Binary add(Binary a, int b);


    /**
     * b is subtracted from a
     *
     * @param a
     * @param b
     * @return
     */
    Binary subtract(Binary a, int b);

    /**
     * a and b are summed
     *
     * @param a
     * @param b
     * @return
     */
    Binary[] multiply(Binary a, Binary b);


    /**
     * b is subtracted from a
     *
     * @param a
     * @param b
     * @return
     */
    Binary[] divide(Binary a, Binary b);

}
