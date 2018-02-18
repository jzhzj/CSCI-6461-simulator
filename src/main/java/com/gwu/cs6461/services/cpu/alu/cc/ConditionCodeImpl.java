package com.gwu.cs6461.services.cpu.alu.cc;

import com.gwu.cs6461.constants.MachineProps;
import org.apache.commons.lang3.StringUtils;

public class ConditionCodeImpl implements ConditionCode{

    private boolean[] values = new boolean[MachineProps.CC_REG_BIT_WIDTH];


    @Override
    public boolean getBit(Type type) {
        return values[type.ordinal()];
    }

    @Override
    public void setBit(Type type, boolean value) {
        values[type.ordinal()] = value;
    }

    @Override
    public String toString() {
        String result = "";
        for(boolean value : values) {
            result = StringUtils.join(result, value ? "1" : "0");
        }
        return result;
    }
}
