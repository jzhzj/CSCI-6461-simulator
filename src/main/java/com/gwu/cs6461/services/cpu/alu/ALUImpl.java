package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

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


    @Override
    public DRAMData[] multiply(DRAMData a, DRAMData b) {
        DRAMData[] dramData = {new DRAMDataImpl(), new DRAMDataImpl()};
        int result = a.getDecimalValue() * b.getDecimalValue();
        String unformatted = Integer.toBinaryString(result);
        String formatted;

        if (unformatted.length() < 2 * MachineProps.WORD_BIT_WIDTH) {
            formatted = StringUtils.leftPad(unformatted, MachineProps.WORD_BIT_WIDTH, result < 0 ? "1" : "0");
        } else {
            formatted = StringUtils.substring(unformatted, unformatted.length() - MachineProps.WORD_BIT_WIDTH);
        }
        String s0 = formatted.substring(0, MachineProps.WORD_BIT_WIDTH);
        String s1 = formatted.substring(MachineProps.WORD_BIT_WIDTH);
        dramData[0].setBinaryValue(s0);
        dramData[1].setBinaryValue(s1);
        return dramData;
    }


    @Override
    public DRAMData[] divide(DRAMData a, DRAMData b) {
        DRAMData[] dramData = {new DRAMDataImpl(), new DRAMDataImpl()};

        int quotient = a.getDecimalValue() / b.getDecimalValue();
        int remainder = a.getDecimalValue() % b.getDecimalValue();

        String quotientStrUnform = Integer.toBinaryString(quotient);
        String remainderStrUnform = Integer.toBinaryString(remainder);
        String quotientStrForm;
        String remainderStrForm;

        if (quotientStrUnform.length() < MachineProps.WORD_BIT_WIDTH) {
            quotientStrForm = StringUtils.leftPad(quotientStrUnform, MachineProps.WORD_BIT_WIDTH, quotient < 0 ? "1" : "0");
        } else {
            quotientStrForm = quotientStrUnform.substring(quotientStrUnform.length() - MachineProps.WORD_BIT_WIDTH);
        }

        if (remainderStrUnform.length() < MachineProps.WORD_BIT_WIDTH) {
            remainderStrForm = StringUtils.leftPad(remainderStrUnform, MachineProps.WORD_BIT_WIDTH, quotient < 0 ? "1" : "0");
        } else {
            remainderStrForm = remainderStrUnform.substring(remainderStrUnform.length() - MachineProps.WORD_BIT_WIDTH);
        }

        dramData[0].setBinaryValue(quotientStrForm);
        dramData[1].setBinaryValue(remainderStrForm);

        return dramData;
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


    @Override
    public DRAMData not(DRAMData a) {
        return new DRAMDataImpl().setDecimalValue(~a.getDecimalValue());
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
