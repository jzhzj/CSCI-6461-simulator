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
    TRAP(OpCodeProps.TRAP_OP_CODE, OpCodeProps.TRAP_CLASS_NAME),

    AMR (OpCodeProps.AMR_OP_CODE, OpCodeProps.AMR_CLASS_NAME),
    SMR (OpCodeProps.SMR_OP_CODE, OpCodeProps.SMR_CLASS_NAME),
    AIR (OpCodeProps.AIR_OP_CODE, OpCodeProps.AIR_CLASS_NAME),
    SIR (OpCodeProps.SIR_OP_CODE, OpCodeProps.SIR_CLASS_NAME),
    MLT (OpCodeProps.MLT_OP_CODE, OpCodeProps.MLT_CLASS_NAME),
    DVD (OpCodeProps.DVD_OP_CODE, OpCodeProps.DVD_CLASS_NAME),
    TRR (OpCodeProps.TRR_OP_CODE, OpCodeProps.TRR_CLASS_NAME),
    AND (OpCodeProps.AND_OP_CODE, OpCodeProps.AND_CLASS_NAME),
    ORR (OpCodeProps.ORR_OP_CODE, OpCodeProps.ORR_CLASS_NAME),
    NOT (OpCodeProps.NOT_OP_CODE, OpCodeProps.NOT_CLASS_NAME),
    SRC (OpCodeProps.SRC_OP_CODE, OpCodeProps.SRC_CLASS_NAME),
    RRC (OpCodeProps.RRC_OP_CODE, OpCodeProps.RRC_CLASS_NAME),

    IN  (OpCodeProps.IN_OP_CODE, OpCodeProps.IN_CLASS_NAME),
    OUT (OpCodeProps.OUT_OP_CODE, OpCodeProps.OUT_CLASS_NAME),
    CHK (OpCodeProps.CHK_OP_CODE, OpCodeProps.CHK_CLASS_NAME),

    JZ  (OpCodeProps.JZ_OP_CODE, OpCodeProps.JZ_CLASS_NAME),
    JNE (OpCodeProps.JNE_OP_CODE, OpCodeProps.JNE_CLASS_NAME),
    JCC (OpCodeProps.JCC_OP_CODE, OpCodeProps.JCC_CLASS_NAME),
    JMA (OpCodeProps.JMA_OP_CODE, OpCodeProps.JMA_CLASS_NAME),
    JSR (OpCodeProps.JSR_OP_CODE, OpCodeProps.JSR_CLASS_NAME),
    RFS (OpCodeProps.RFS_OP_CODE, OpCodeProps.RFS_CLASS_NAME),
    SOB (OpCodeProps.SOB_OP_CODE, OpCodeProps.SOB_CLASS_NAME),
    JGE (OpCodeProps.JGE_OP_CODE, OpCodeProps.JGE_CLASS_NAME);

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
        return StringUtils.substring(data.getBinaryValue(), 0, MachineProps.OPERATION_CODE_BIT_WIDTH);
    }

    public static int getOpcode(DRAMData data){
        return Integer.parseInt(getOpcodeBinary(data), 2);
    }
}
