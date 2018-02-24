package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cpu.alu.cc.ConditionCode;
import com.gwu.cs6461.services.cpu.registers.CCRImpl;
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
        // add a and b, then return the result
        short result = (short) (((short)a.getDecimalValue()) + (short)b);
        int test = a.getDecimalValue() + b;
        // set cc(0) <- true
        if (test > Short.MAX_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
        }
        // set cc(1) <- true
        if (test < Short.MIN_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
        }
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary add(Binary a, Binary b) {
        // add a and b, then return the result
        short result = (short) (((short)a.getDecimalValue()) + ((short)b.getDecimalValue()));
        int test = a.getDecimalValue() + b.getDecimalValue();
        // set cc(0) <- true
        if (test > Short.MAX_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
        }
        // set cc(1) <- true
        if (test < Short.MIN_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
        }
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary subtract(Binary a, int b) {
        // subtract b from a, then return the result
        short result = (short) (((short)a.getDecimalValue()) - (short)b);
        int test = a.getDecimalValue() - b;
        // set cc(0) <- true
        if (test > Short.MAX_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
        }
        // set cc(1) <- true
        if (test < Short.MIN_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
        }
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary subtract(Binary a, Binary b) {
        // subtract b from a, then return the result
        short result = (short) (((short)a.getDecimalValue()) - ((short)b.getDecimalValue()));
        int test = a.getDecimalValue() - b.getDecimalValue();
        // set cc(0) <- true
        if (test > Short.MAX_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
        }
        // set cc(1) <- true
        if (test < Short.MIN_VALUE) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
        }
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary[] multiply(Binary a, Binary b) {
        DRAMData[] dramData = {new DRAMDataImpl(), new DRAMDataImpl()};
        // a * b
        int result = (short)a.getDecimalValue() * (short) b.getDecimalValue();
        // set cc(0) <- true
        if (result > (Short.MAX_VALUE * Short.MAX_VALUE)) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
        }
        short r0 = (short) (result>>MachineProps.WORD_BIT_WIDTH);
        short r1 = (short)result;
        // store the higher order bits
        dramData[0].setDecimalValue(r0);
        // store the lower order bits
        dramData[1].setDecimalValue(r1);
        return dramData;
    }


    @Override
    public Binary[] divide(Binary a, Binary b) {
        DRAMData[] dramData = {new DRAMDataImpl(), new DRAMDataImpl()};
        // set cc(2) <- true
        if (b.getDecimalValue() == 0) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.DIV_ZERO, true);
        }
        // quotient
        short quotient = (short) (a.getDecimalValue() / b.getDecimalValue());
        // remainder
        short remainder = (short) (a.getDecimalValue() % b.getDecimalValue());
        // store the quotient
        dramData[0].setDecimalValue(quotient);
        // store the remainder
        dramData[1].setDecimalValue(remainder);

        return dramData;
    }


    @Override
    public Binary and(Binary a, Binary b) {
        // Logical And of a and b, then return the result
        short result = (short)((short)a.getDecimalValue() & (short) b.getDecimalValue());
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary or(Binary a, Binary b) {
        //Logical Or of a and b, then return the result
        short result = (short)((short)a.getDecimalValue() | (short)b.getDecimalValue());
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary not(Binary a) {
        //Logical Not of a, then return the result
        short result = (short)(~a.getDecimalValue());
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public void test(Binary a, Binary b) {
        if ((short)a.getDecimalValue() == (short)b.getDecimalValue()) {
            // set cc(3) <- true
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.EQ_OR_NOT, true);
        } else {
            // set cc(3) <- false
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.EQ_OR_NOT, false);
        }
    }


    @Override
    public Binary arithmeticShiftR(Binary a, int count) {
        short num = (short) a.getDecimalValue();
        // Arithmetically Shift register by count
        for (int i = 0; i < count; i++) {
            // set cc(1) <- true
            if ((num & 1) == 1) {
                CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
            }
            num = (short) (num >> 1);
        }
        return new DRAMDataImpl().setDecimalValue(num);
    }

    //TODO to be implemented
    @Override
    public Binary logicalShiftL(Binary a, int count) {

        return null;
    }

    //TODO to be implemented
    @Override
    public Binary logicalShiftR(Binary a, int count) {
        return null;
    }

    //TODO to be implemented
    @Override
    public Binary logicalRotateL(Binary a, int count) {
        return null;
    }

    //TODO to be implemented
    @Override
    public Binary logicalRotateR(Binary a, int count) {
        return null;
    }
}
