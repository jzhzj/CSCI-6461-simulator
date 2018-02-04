package com.gwu.cs6461.services.instruction;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.constants.OpCodeProps;
import com.gwu.cs6461.services.dram.DRAMData;
import org.apache.commons.lang3.StringUtils;

/**
 * Operation code: 6 bits
 * Refers to 64 possible operations, however, not so many in this one
 */
public enum OpCode {
    LDA (OpCodeProps.LDA_OP_CODE, OpCodeProps.LDA_CLASS_NAME),
    LDR (OpCodeProps.LDR_OP_CODE, OpCodeProps.LDR_CLASS_NAME),
    LDX (OpCodeProps.LDX_OP_CODE, OpCodeProps.LDX_CLASS_NAME),
    STR (OpCodeProps.STR_OP_CODE, OpCodeProps.STR_CLASS_NAME),
    STX (OpCodeProps.STX_OP_CODE, OpCodeProps.STX_CLASS_NAME),
    HLT (OpCodeProps.HLT_OP_CODE, OpCodeProps.HLT_CLASS_NAME),
    TRAP(OpCodeProps.TRAP_OP_CODE, OpCodeProps.TRAP_CLASS_NAME);

    private int value;
    private String instructionClassName;

    public int getValue() {
        return value;
    }

    public static String getInstructionImplClassName (DRAMData data) throws ClassNotFoundException {
        int code = getOpcode(data);
        for (OpCode opCode : OpCode.values()){
            if(code == opCode.value){
                return opCode.instructionClassName;
            }
        }
        throw new ClassNotFoundException();
    }

    OpCode(int opCode, String instructionClassName) {
        this.value = opCode;
        this.instructionClassName = instructionClassName;
    }



    public static String getOpcodeBinary(DRAMData data){
        return StringUtils.substring(data.getBinary(), 0, MachineProps.OPERATION_CODE_BIT_WIDTH);
    }

    public static int getOpcode(DRAMData data){
        return Integer.parseInt(getOpcodeBinary(data), 2);
    }
}
