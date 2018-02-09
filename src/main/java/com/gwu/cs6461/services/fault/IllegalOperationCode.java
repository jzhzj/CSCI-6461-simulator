package com.gwu.cs6461.services.fault;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cpu.registers.MFRImpl;
import com.gwu.cs6461.util.Binary;
import org.apache.commons.lang3.StringUtils;

public class IllegalOperationCode extends Throwable implements MachineFault {

    public IllegalOperationCode() {
        MFRImpl.getInstance().write(this);
    }

    private Binary id = new Binary() {
        @Override
        public int getDecimalValue() {
            return MachineProps.ILLEGAL_OPERATION_CODE_ID;
        }

        @Override
        public String getBinaryValue() {
            String unformatted = Integer.toBinaryString(getDecimalValue());
            if(unformatted.length() < MachineProps.MFR_REG_BIT_WIDTH){
                return StringUtils.leftPad(unformatted, MachineProps.MFR_REG_BIT_WIDTH, "0");
            } else {
                return StringUtils.substring(unformatted, unformatted.length() - MachineProps.MFR_REG_BIT_WIDTH);
            }
        }

        @Override
        public String getHexValue() {
            String unformatted = Integer.toHexString(getDecimalValue());
            int hexLength = MachineProps.MFR_REG_BIT_WIDTH * 2 / Byte.SIZE;
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
