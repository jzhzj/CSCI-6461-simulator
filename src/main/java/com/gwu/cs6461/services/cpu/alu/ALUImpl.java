package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

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
    public DRAMData add(DRAMData a, int b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() + b);
    }

    @Override
    public DRAMData add(DRAMData a, DRAMData b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() + b.getDecimalValue());
    }

    @Override
    public DRAMData subtract(DRAMData a, int b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() - b);
    }

    @Override
    public DRAMData subtract(DRAMData a, DRAMData b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() - b.getDecimalValue());
    }

    //TODO
    @Override
    public DRAMData time(DRAMData a, DRAMData b) {
        return null;
    }

    //TODO
    @Override
    public DRAMData divide(DRAMData a, DRAMData b) {
        return null;
    }

    //TODO
    @Override
    public DRAMData and(DRAMData a, DRAMData b) {
        return new DRAMDataImpl();
    }

    //TODO
    @Override
    public DRAMData or(DRAMData a, DRAMData b) {
        return new DRAMDataImpl();
    }

    //TODO
    @Override
    public DRAMData not(DRAMData a) {
        return new DRAMDataImpl();
    }

    //TODO
    @Override
    public DRAMData arithmeticShiftL(DRAMData a) {
        return null;
    }

    //TODO
    @Override
    public DRAMData arithmeticShiftR(DRAMData a) {
        return null;
    }

    //TODO
    @Override
    public DRAMData logicalShiftL(DRAMData a) {
        return null;
    }

    //TODO
    @Override
    public DRAMData logicalShiftR(DRAMData a) {
        return null;
    }

    //TODO
    @Override
    public DRAMData logicalRotateL(DRAMData a) {
        return null;
    }

    //TODO
    @Override
    public DRAMData logicalRotateR(DRAMData a) {
        return null;
    }
}
