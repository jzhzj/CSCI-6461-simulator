package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.instruction.Instruction;
import com.gwu.cs6461.services.instruction.OpCode;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * DRAM data at each address, represented in 16 bits = 2 bytes = 1 word
 */

public class DRAMDataImpl implements DRAMData {

    public static final int MIN_VALUE = - (int) Math.pow(2, (MachineProps.WORD_BIT_WIDTH / 2));
    public static final int MAX_VALUE = (int) Math.pow(2, MachineProps.WORD_BIT_WIDTH) - 1;

    private int data;

    @Override
    public int getDecimalValue() {
        return data;
    }

    @Override
    public String getBinaryValue() {
        String unformatted = Integer.toBinaryString(data);
        if(unformatted.length() < MachineProps.WORD_BIT_WIDTH){
            return StringUtils.leftPad(unformatted, MachineProps.WORD_BIT_WIDTH, data < 0 ? "1" : "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - MachineProps.WORD_BIT_WIDTH);
        }

    }

    @Override
    public String getHexValue() {
        String unformatted = Integer.toHexString(data);
        int hexLength = MachineProps.WORD_BIT_WIDTH / Byte.SIZE * 2;
        if(unformatted.length() < hexLength){
            return StringUtils.leftPad(unformatted, hexLength, data < 0 ? "f" : "0");
        } else {
            return StringUtils.substring(unformatted, unformatted.length() - hexLength);
        }
    }

    @Override
    public DRAMDataImpl setDecimalValue(int decimalValue) throws IllegalArgumentException{
        if(decimalValue <  MIN_VALUE || decimalValue > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        data = decimalValue;
        return this;
    }

    @Override
    public DRAMDataImpl setDecimalValue(String decimalValue) throws IllegalArgumentException {
        try{
            int value = Integer.parseInt(decimalValue);
            return setDecimalValue(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public DRAMDataImpl setBinaryValue(String binaryValue) throws IllegalArgumentException {
        try{
            int value = Integer.parseInt(binaryValue, 2);
            return setDecimalValue(value);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Instruction toInstruction() {
        // determine instruction type by opcode
        Instruction instruction = null;

        try {
            String className = OpCode.getInstructionImplClassName(this);
            Class instructionImpl = Class.forName(className);
            instruction = (Instruction) instructionImpl.getConstructor().newInstance();
            instruction.fromDRAMData(this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return instruction;
    }
}
