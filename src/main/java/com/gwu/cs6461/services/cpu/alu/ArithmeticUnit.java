package com.gwu.cs6461.services.cpu.alu;

/**
 * Arithmetic Unit
 * Responsible for handling all numerical operations.
 * TODO need more detailed design.
 */
public interface ArithmeticUnit {
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
}
