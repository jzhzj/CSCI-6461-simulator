package com.gwu.cs6461.services.cpu.alu.cc;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.util.Binary;
import org.apache.commons.lang3.StringUtils;

/**
 * Equal or Not
 * cc(3)
 */
public class EqOrNot extends Throwable implements ConditionCode{

    private Binary id = new Binary() {
        @Override
        public int getDecimalValue() {
            return MachineProps.EQUAL_OR_NOT_ID;
        }

        @Override
        public String getBinaryValue() {
            String unformatted = Integer.toBinaryString(getDecimalValue());
            if(unformatted.length() < MachineProps.CC_REG_BIT_WIDTH){
                return StringUtils.leftPad(unformatted, MachineProps.CC_REG_BIT_WIDTH, "0");
            } else {
                return StringUtils.substring(unformatted, unformatted.length() - MachineProps.CC_REG_BIT_WIDTH);
            }
        }

        @Override
        public String getHexValue() {
            String unformatted = Integer.toHexString(getDecimalValue());
            int hexLength = MachineProps.CC_REG_BIT_WIDTH * 2 / Byte.SIZE;
            if(unformatted.length() < hexLength){
                return StringUtils.leftPad(unformatted, hexLength, "0");
            } else {
                return StringUtils.substring(unformatted, unformatted.length() - hexLength);
            }
        }

        @Override
        public Binary setDecimalValue(int decimalValue) throws IllegalArgumentException {
            return null;
        }

        @Override
        public Binary setDecimalValue(String decimalValue) throws IllegalArgumentException {
            return null;
        }

        @Override
        public Binary setBinaryValue(String binaryValue) throws IllegalArgumentException {
            return null;
        }
    };

    @Override
    public Binary getId() {
        return id;
    }
}
