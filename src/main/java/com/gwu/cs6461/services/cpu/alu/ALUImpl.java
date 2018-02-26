package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cpu.alu.cc.ConditionCode;
import com.gwu.cs6461.services.cpu.registers.CCRImpl;
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
    public Binary add(Binary a, int b) {
        short[] var = getShortValue(a, b);
        // add a and b, then return the result
        short result = (short) (var[1] + var[2]);
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
        return add(a, b.getDecimalValue());
    }


    @Override
    public Binary subtract(Binary a, int b) {
        short[] var = getShortValue(a, b);
        // subtract b from a, then return the result
        short result = (short) (var[0] - var[1]);
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
        return subtract(a, b.getDecimalValue());
    }


    @Override
    public Binary[] multiply(Binary a, Binary b) {
        DRAMData[] dramData = {new DRAMDataImpl(), new DRAMDataImpl()};
        short[] var = getShortValue(a, b);
        // a * b
        int result = var[0] * var[1];
        // set cc(0) <- true
        if (result > (Short.MAX_VALUE * Short.MAX_VALUE)) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
        }
        short r1 = (short) result;
        short r0 = (short) (result >> MachineProps.WORD_BIT_WIDTH);
        // store the higher order bits
        dramData[0].setDecimalValue(r0);
        // store the lower order bits
        dramData[1].setDecimalValue(r1);
        return dramData;
    }


    @Override
    public Binary[] divide(Binary a, Binary b) {
        DRAMData[] dramData = {new DRAMDataImpl(), new DRAMDataImpl()};
        short[] var = getShortValue(a, b);
        // set cc(2) <- true
        if (b.getDecimalValue() == 0) {
            CCRImpl.getInstance().read().setBit(ConditionCode.Type.DIV_ZERO, true);
        }
        // quotient
        short quotient = (short) (var[0] / var[1]);
        // remainder
        short remainder = (short) (var[0] % var[1]);
        // store the quotient
        dramData[0].setDecimalValue(quotient);
        // store the remainder
        dramData[1].setDecimalValue(remainder);

        return dramData;
    }


    @Override
    public Binary and(Binary a, Binary b) {
        short[] var = getShortValue(a, b);
        // Logical And of a and b, then return the result
        short result = (short) (var[0] & var[1]);
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary or(Binary a, Binary b) {
        short[] var = getShortValue(a, b);
        // Logical Or of a and b, then return the result
        short result = (short) (var[0] | var[1]);
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary not(Binary a) {
        // Logical Not of a, then return the result
        short result = (short) (~a.getDecimalValue());
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public void test(Binary a, Binary b) {
        short[] var = getShortValue(a, b);
        if (var[0] == var[1]) {
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
        // Arithmetically Shift register right by count
        for (int i = 0; i < count; i++) {
            // set cc(1) <- true
            if ((num & 1) == 1) {
                CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
            }
            num = (short) (num >> 1);
        }
        return new DRAMDataImpl().setDecimalValue(num);
    }


    @Override
    public Binary logicalShiftL(Binary a, int count) {
        short num = (short) a.getDecimalValue();
        // Logically Shift register left by count
        for (int i = 0; i < count; i++) {
            // set cc(0) <- true
            if ((num & Short.MIN_VALUE) == Short.MIN_VALUE) {
                CCRImpl.getInstance().read().setBit(ConditionCode.Type.OVER_FLOW, true);
            }
            num = (short) (num << 1);
        }
        return new DRAMDataImpl().setDecimalValue(num);
    }


    @Override
    public Binary logicalShiftR(Binary a, int count) {
        short num = (short) a.getDecimalValue();
        // Logically Shift register right by count
        for (int i = 0; i < count; i++) {
            // set cc(1) <- true
            if ((num & 1) == 1) {
                CCRImpl.getInstance().read().setBit(ConditionCode.Type.UNDER_FLOW, true);
            }
            num = (short) (num >>> 1);
        }
        return new DRAMDataImpl().setDecimalValue(num);
    }


    @Override
    public Binary logicalRotateL(Binary a, int count) {
        int num = a.getDecimalValue();
        num = num << MachineProps.WORD_BIT_WIDTH >>> MachineProps.WORD_BIT_WIDTH;
        // get higher bits that over flow during rotate
        short higherBits = (short) (num >>> (MachineProps.WORD_BIT_WIDTH - count));
        // get lower bits that are left during rotate
        short lowerBits = (short) (num << count);
        // merge higher bits and lower bits
        short result = (short) (higherBits | lowerBits);
        return new DRAMDataImpl().setDecimalValue(result);
    }


    @Override
    public Binary logicalRotateR(Binary a, int count) {
        // Rotating right by count equals to rotating left by WORD_BIT_WIDTH - count
        return logicalRotateL(a, MachineProps.WORD_BIT_WIDTH - count);
    }

    private short[] getShortValue(Binary a, int b) {
        short[] args = {(short) a.getDecimalValue(), (short) b};
        return args;
    }

    private short[] getShortValue(Binary a, Binary b) {
        return getShortValue(a, b.getDecimalValue());
    }
}
