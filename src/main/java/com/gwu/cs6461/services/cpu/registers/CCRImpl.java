package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.cpu.alu.cc.ConditionCode;

import java.util.Observable;

/**
 * Singleton
 * Condition Code: set when arithmetic/logical operations are executed;
 * it has four 1-bit elements: overflow, underflow, division by zero, equal-or-not.
 * They may be referenced as cc(0), cc(1), cc(2), cc(3). Or by the names OVERFLOW, UNDERFLOW, DIVZERO, EQUALORNOT
 */
public class CCRImpl extends Observable implements Register<ConditionCode>{

    private static CCRImpl ourInstance = new CCRImpl();

    public static CCRImpl getInstance() {
        return ourInstance;
    }

    private CCRImpl() {

    }

    private ConditionCode conditionCode;

    @Override
    public void write(ConditionCode data) {
        conditionCode = data;
        setChanged();
        notifyObservers();
    }

    @Override
    public ConditionCode read() {
        return conditionCode;
    }

    @Override
    public void reset() {
        write(null);
    }
}
