package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
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
    public DRAMData add(DRAMData a, int b) {
        DRAMData data = new DRAMDataImpl().setDecimalValue(a.getDecimalValue() + b);
        return data;
    }

    @Override
    public DRAMData add(DRAMData a, DRAMData b) {
        DRAMData data = new DRAMDataImpl().setDecimalValue(a.getDecimalValue() + b.getDecimalValue());
        return data;
    }

    @Override
    public DRAMData subtract(DRAMData a, int b) {
        DRAMData data = new DRAMDataImpl().setDecimalValue(a.getDecimalValue() - b);
        return data;
    }

    @Override
    public DRAMData subtract(DRAMData a, DRAMData b) {
        DRAMData data = new DRAMDataImpl().setDecimalValue(a.getDecimalValue() - b.getDecimalValue());
        return data;
    }

    @Override
    public DRAMData time(DRAMData a, DRAMData b) {
        return null;
    }

    @Override
    public DRAMData divide(DRAMData a, DRAMData b) {
        return null;
    }

    @Override
    public DRAMData and(DRAMData a, DRAMData b) {
        DRAMData data = new DRAMDataImpl();
        return data;
    }

    @Override
    public DRAMData or(DRAMData a, DRAMData b) {
        DRAMData data = new DRAMDataImpl();
        return data;
    }

    @Override
    public DRAMData not(DRAMData a) {
        DRAMData data = new DRAMDataImpl();
        return data;
    }

    @Override
    public DRAMData arithmeticShiftL(DRAMData a) {
        return null;
    }

    @Override
    public DRAMData arithmeticShiftR(DRAMData a) {
        return null;
    }

    @Override
    public DRAMData logicalShiftL(DRAMData a) {
        return null;
    }

    @Override
    public DRAMData logicalShiftR(DRAMData a) {
        return null;
    }

    @Override
    public DRAMData logicalRotateL(DRAMData a) {
        return null;
    }

    @Override
    public DRAMData logicalRotateR(DRAMData a) {
        return null;
    }
}
