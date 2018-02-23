package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cpu.registers.Register;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.util.Binary;
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
    public Binary add(Binary a, int b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() + b);
    }

    @Override
    public Binary add(Binary a, Binary b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() + b.getDecimalValue());
    }

    @Override
    public Binary subtract(Binary a, int b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() - b);
    }

    @Override
    public Binary subtract(Binary a, Binary b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() - b.getDecimalValue());
    }


    @Override
    public Binary[] multiply(Binary a, Binary b) {
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
    public Binary[] divide(Binary a, Binary b) {
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


    @Override
    public Binary and(Binary a, Binary b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() & b.getDecimalValue());
    }


    @Override
    public Binary or(Binary a, Binary b) {
        return new DRAMDataImpl().setDecimalValue(a.getDecimalValue() | b.getDecimalValue());
    }


    @Override
    public Binary not(Binary a) {
        return new DRAMDataImpl().setDecimalValue(~a.getDecimalValue());
    }

    //TODO
    @Override
    public void test(Binary a, Binary b) {
        if (a.getDecimalValue() == b.getDecimalValue()) {

        } else {

        }
    }

    //TODO
    @Override
    public Binary arithmeticShiftR(Binary a, int count) {
        return null;
    }

    //TODO
    @Override
    public Binary logicalShiftL(Binary a, int count) {
        return null;
    }

    //TODO
    @Override
    public Binary logicalShiftR(Binary a, int count) {
        return null;
    }

    //TODO
    @Override
    public Binary logicalRotateL(Binary a, int count) {
        return null;
    }

    //TODO
    @Override
    public Binary logicalRotateR(Binary a, int count) {
        return null;
    }
}
