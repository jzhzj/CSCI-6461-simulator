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

}
