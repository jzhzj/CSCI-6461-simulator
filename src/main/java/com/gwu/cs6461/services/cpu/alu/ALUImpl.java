package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.alu.cc.EqOrNot;
import com.gwu.cs6461.services.cpu.alu.cc.Overflow;
import com.gwu.cs6461.services.cpu.alu.cc.DivZero;
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
    public Binary add(Binary a, Binary b) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary addWithCarry(Binary a, Binary b) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary subtract(Binary a, Binary b) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary subtractWithBorrow(Binary a, Binary b) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary negate(Binary a) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary increment(Binary a) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary decrement(Binary a) throws DivZero, Overflow, EqOrNot {
        return null;
    }

    @Override
    public Binary passThrough(Binary a) throws DivZero, EqOrNot {
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
