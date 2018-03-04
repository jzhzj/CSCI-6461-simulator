package com.gwu.cs6461.constants;

import java.util.ResourceBundle;

public final class OpCodeProps {

    static {
        ResourceBundle rb = ResourceBundle.getBundle("op_code");

        LDA_OP_CODE = Integer.parseInt(rb.getString("LDA_OP_CODE"));
        LDA_CLASS_NAME = rb.getString("LDA_CLASS_NAME");
        LDR_OP_CODE = Integer.parseInt(rb.getString("LDR_OP_CODE"));
        LDR_CLASS_NAME = rb.getString("LDR_CLASS_NAME");
        LDX_OP_CODE = Integer.parseInt(rb.getString("LDX_OP_CODE"));
        LDX_CLASS_NAME = rb.getString("LDX_CLASS_NAME");
        STR_OP_CODE = Integer.parseInt(rb.getString("STR_OP_CODE"));
        STR_CLASS_NAME = rb.getString("STR_CLASS_NAME");
        STX_OP_CODE = Integer.parseInt(rb.getString("STX_OP_CODE"));
        STX_CLASS_NAME = rb.getString("STX_CLASS_NAME");

        HLT_OP_CODE = Integer.parseInt(rb.getString("HLT_OP_CODE"));
        HLT_CLASS_NAME = rb.getString("HLT_CLASS_NAME");
        TRAP_OP_CODE = Integer.parseInt(rb.getString("TRAP_OP_CODE"));
        TRAP_CLASS_NAME = rb.getString("TRAP_CLASS_NAME");

        AMR_OP_CODE = Integer.parseInt(rb.getString("AMR_OP_CODE"));
        AMR_CLASS_NAME = rb.getString("AMR_CLASS_NAME");
        SMR_OP_CODE = Integer.parseInt(rb.getString("SMR_OP_CODE"));
        SMR_CLASS_NAME = rb.getString("SMR_CLASS_NAME");
        AIR_OP_CODE = Integer.parseInt(rb.getString("AIR_OP_CODE"));
        AIR_CLASS_NAME = rb.getString("AIR_CLASS_NAME");
        SIR_OP_CODE = Integer.parseInt(rb.getString("SIR_OP_CODE"));
        SIR_CLASS_NAME = rb.getString("SIR_CLASS_NAME");
        MLT_OP_CODE = Integer.parseInt(rb.getString("MLT_OP_CODE"));
        MLT_CLASS_NAME = rb.getString("MLT_CLASS_NAME");
        DVD_OP_CODE = Integer.parseInt(rb.getString("DVD_OP_CODE"));
        DVD_CLASS_NAME = rb.getString("DVD_CLASS_NAME");
        TRR_OP_CODE = Integer.parseInt(rb.getString("TRR_OP_CODE"));
        TRR_CLASS_NAME = rb.getString("TRR_CLASS_NAME");
        AND_OP_CODE = Integer.parseInt(rb.getString("AND_OP_CODE"));
        AND_CLASS_NAME = rb.getString("AND_CLASS_NAME");
        ORR_OP_CODE = Integer.parseInt(rb.getString("ORR_OP_CODE"));
        ORR_CLASS_NAME = rb.getString("ORR_CLASS_NAME");
        NOT_OP_CODE = Integer.parseInt(rb.getString("NOT_OP_CODE"));
        NOT_CLASS_NAME = rb.getString("NOT_CLASS_NAME");
        SRC_OP_CODE = Integer.parseInt(rb.getString("SRC_OP_CODE"));
        SRC_CLASS_NAME = rb.getString("SRC_CLASS_NAME");
        RRC_OP_CODE = Integer.parseInt(rb.getString("RRC_OP_CODE"));
        RRC_CLASS_NAME = rb.getString("RRC_CLASS_NAME");

        IN_OP_CODE = Integer.parseInt(rb.getString("IN_OP_CODE"));
        IN_CLASS_NAME = rb.getString("IN_CLASS_NAME");
        OUT_OP_CODE = Integer.parseInt(rb.getString("OUT_OP_CODE"));
        OUT_CLASS_NAME = rb.getString("OUT_CLASS_NAME");
        CHK_OP_CODE = Integer.parseInt(rb.getString("CHK_OP_CODE"));
        CHK_CLASS_NAME = rb.getString("CHK_CLASS_NAME");

        JZ_OP_CODE = Integer.parseInt(rb.getString("JZ_OP_CODE"));
        JZ_CLASS_NAME = rb.getString("JZ_CLASS_NAME");
        JNE_OP_CODE = Integer.parseInt(rb.getString("JNE_OP_CODE"));
        JNE_CLASS_NAME = rb.getString("JNE_CLASS_NAME");
        JCC_OP_CODE = Integer.parseInt(rb.getString("JCC_OP_CODE"));
        JCC_CLASS_NAME = rb.getString("JCC_CLASS_NAME");
        JMA_OP_CODE = Integer.parseInt(rb.getString("JMA_OP_CODE"));
        JMA_CLASS_NAME = rb.getString("JMA_CLASS_NAME");
        JSR_OP_CODE = Integer.parseInt(rb.getString("JSR_OP_CODE"));
        JSR_CLASS_NAME = rb.getString("JSR_CLASS_NAME");
        RFS_OP_CODE = Integer.parseInt(rb.getString("RFS_OP_CODE"));
        RFS_CLASS_NAME = rb.getString("RFS_CLASS_NAME");
        SOB_OP_CODE = Integer.parseInt(rb.getString("SOB_OP_CODE"));
        SOB_CLASS_NAME = rb.getString("SOB_CLASS_NAME");
        JGE_OP_CODE = Integer.parseInt(rb.getString("JGE_OP_CODE"));
        JGE_CLASS_NAME = rb.getString("JGE_CLASS_NAME");
    }

    public static final int LDA_OP_CODE;
    public static final String LDA_CLASS_NAME;
    public static final int LDR_OP_CODE;
    public static final String LDR_CLASS_NAME;
    public static final int LDX_OP_CODE;
    public static final String LDX_CLASS_NAME;
    public static final int STR_OP_CODE;
    public static final String STR_CLASS_NAME;
    public static final int STX_OP_CODE;
    public static final String STX_CLASS_NAME;

    public static final int HLT_OP_CODE;
    public static final String HLT_CLASS_NAME;
    public static final int TRAP_OP_CODE;
    public static final String TRAP_CLASS_NAME;

    public static final int AMR_OP_CODE;
    public static final String AMR_CLASS_NAME;
    public static final int SMR_OP_CODE;
    public static final String SMR_CLASS_NAME;
    public static final int AIR_OP_CODE;
    public static final String AIR_CLASS_NAME;
    public static final int SIR_OP_CODE;
    public static final String SIR_CLASS_NAME;
    public static final int MLT_OP_CODE;
    public static final String MLT_CLASS_NAME;
    public static final int DVD_OP_CODE;
    public static final String DVD_CLASS_NAME;
    public static final int TRR_OP_CODE;
    public static final String TRR_CLASS_NAME;
    public static final int AND_OP_CODE;
    public static final String AND_CLASS_NAME;
    public static final int ORR_OP_CODE;
    public static final String ORR_CLASS_NAME;
    public static final int NOT_OP_CODE;
    public static final String NOT_CLASS_NAME;
    public static final int SRC_OP_CODE;
    public static final String SRC_CLASS_NAME;
    public static final int RRC_OP_CODE;
    public static final String RRC_CLASS_NAME;

    public static final int IN_OP_CODE;
    public static final String IN_CLASS_NAME;
    public static final int OUT_OP_CODE;
    public static final String OUT_CLASS_NAME;
    public static final int CHK_OP_CODE;
    public static final String CHK_CLASS_NAME;

    public static final int JZ_OP_CODE;
    public static final String JZ_CLASS_NAME;
    public static final int JNE_OP_CODE;
    public static final String JNE_CLASS_NAME;
    public static final int JCC_OP_CODE;
    public static final String JCC_CLASS_NAME;
    public static final int JMA_OP_CODE;
    public static final String JMA_CLASS_NAME;
    public static final int JSR_OP_CODE;
    public static final String JSR_CLASS_NAME;
    public static final int RFS_OP_CODE;
    public static final String RFS_CLASS_NAME;
    public static final int SOB_OP_CODE;
    public static final String SOB_CLASS_NAME;
    public static final int JGE_OP_CODE;
    public static final String JGE_CLASS_NAME;



}
