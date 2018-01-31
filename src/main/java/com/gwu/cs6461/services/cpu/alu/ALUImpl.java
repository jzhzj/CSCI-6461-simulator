package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.flags.Negative;
import com.gwu.cs6461.services.cpu.flags.Overflow;
import com.gwu.cs6461.services.cpu.flags.Zero;
import com.gwu.cs6461.util.Binary;

/**
 * Singleton
 * Arithmetic and Logical Unit
 */
public class ALUImpl implements ALU {

    private static ALUImpl ourInstance = new ALUImpl();

    public static ALUImpl getInstance() {
        return ourInstance;
    }

    private ALUImpl() {

    }

    @Override
    public Binary add(Binary a, Binary b) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary addWithCarry(Binary a, Binary b) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary subtract(Binary a, Binary b) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary subtractWithBorrow(Binary a, Binary b) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary negate(Binary a) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary increment(Binary a) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary decrement(Binary a) throws Zero, Overflow, Negative {
        return null;
    }

    @Override
    public Binary passThrough(Binary a) throws Zero, Negative {
        return null;
    }


    @Override
    public boolean and() {
        return false;
    }

    @Override
    public boolean or() {
        return false;
    }

    @Override
    public boolean not() {
        return false;
    }
}
