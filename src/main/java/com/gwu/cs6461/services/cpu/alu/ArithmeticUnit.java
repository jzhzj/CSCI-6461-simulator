package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.flags.Negative;
import com.gwu.cs6461.services.cpu.flags.Overflow;
import com.gwu.cs6461.services.cpu.flags.Zero;
import com.gwu.cs6461.util.Binary;

/**
 * Arithmetic Unit
 * Responsible for handling all numerical operations.
 * TODO need more detailed design.
 */
public interface ArithmeticUnit {

    /**
     * a and b are summed
     * @param a
     * @param b
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary add(Binary a, Binary b) throws Zero, Overflow, Negative;


    /**
     * a and b and a Carry-In bit are all summed
     * @param a
     * @param b
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary addWithCarry(Binary a, Binary b) throws Zero, Overflow, Negative;

    /**
     * b is subtracted from a
     * @param a
     * @param b
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary subtract(Binary a, Binary b) throws Zero, Overflow, Negative;


    /**
     * b is subtracted from a with borrow (carry-in)
     * @param a
     * @param b
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary subtractWithBorrow(Binary a, Binary b) throws Zero, Overflow, Negative;


    /**
     * a is subtracted from 0, flipping its sign
     * @param a
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary negate(Binary a) throws Zero, Overflow, Negative;


    /**
     * add 1 to a
     * @param a
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary increment(Binary a) throws Zero, Overflow, Negative;


    /**
     * subtract 1 from a
     * @param a
     * @return
     * @throws Zero
     * @throws Overflow
     * @throws Negative
     */
    Binary decrement(Binary a) throws Zero, Overflow, Negative;

    /**
     * all bits of a are passed through unmodified
     * @param a
     * @return
     * @throws Zero
     * @throws Negative
     */
    Binary passThrough(Binary a) throws Zero, Negative;
}
