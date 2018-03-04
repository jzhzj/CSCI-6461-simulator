package com.gwu.cs6461.services.cpu.alu.cc;

public interface ConditionCode {
    enum Type {
        OVER_FLOW,
        UNDER_FLOW,
        DIV_ZERO,
        EQ_OR_NOT
    }

    boolean getBit(Type type);
    ConditionCode setBit(Type type, boolean value);

}
