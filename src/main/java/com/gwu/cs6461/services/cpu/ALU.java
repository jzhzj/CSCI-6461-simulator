package com.gwu.cs6461.services.cpu;

/**
 * Defines what ALU does
 */
public interface ALU {
    // what arithmetic unit does

    // A and B are summed
    void add();

    // A and B and a Carry-In bit are all summed
    void addWithCarry();

    // B is subtracted from A
    void subtract();

    // B is subtracted from A with borrow (carry-in)
    void subtractWithBorrow();

    // A is subtracted from 0, flipping its sign
    void negate();

    // add 1 to A
    void increment();

    // subtract 1 from A
    void decrement();

    // all bits of A are passed through unmodified
    void passThrough();



    // what logic unit does
    void and();
    void or();
    void not();
}
