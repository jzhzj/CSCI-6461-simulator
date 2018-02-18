package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.util.Binary;

/**
 * Defines what Arithmetic Unit does
 * ALU is responsible for handling all numerical operations.
 * TODO need more detailed design.
 */
public interface ArithmeticUnit {

    /**
     * a and b are summed
     * @param a
     * @param b
     * @return
     */
    Binary add(Binary a, Binary b);


    /**
     * a and b and a Carry-In bit are all summed
     * @param a
     * @param b
     * @return
     */
    Binary addWithCarry(Binary a, Binary b);

    /**
     * b is subtracted from a
     * @param a
     * @param b
     * @return
     */
    Binary subtract(Binary a, Binary b);


    /**
     * b is subtracted from a with borrow (carry-in)
     * @param a
     * @param b
     * @return
     */
    Binary subtractWithBorrow(Binary a, Binary b);


    /**
     * a is subtracted from 0, flipping its sign
     * @param a
     * @return
     */
    Binary negate(Binary a);


    /**
     * add 1 to a
     * @param a
     * @return
     */
    Binary increment(Binary a);


    /**
     * subtract 1 from a
     * @param a
     * @return
     */
    Binary decrement(Binary a);

    /**
     * all bits of a are passed through unmodified
     * @param a
     * @return
     */
    Binary passThrough(Binary a);
}
