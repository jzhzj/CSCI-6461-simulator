package com.gwu.cs6461.constants;

import java.util.ResourceBundle;

public final class MachineProps {

    static {
        ResourceBundle rb = ResourceBundle.getBundle("machine");

        // sizes and widths
        WORD_BIT_WIDTH = Integer.parseInt(rb.getString("WORD_BIT_WIDTH"));
        DRAM_WORD_SIZE = Integer.parseInt(rb.getString("DRAM_WORD_SIZE"));
        GENERAL_PURPOSE_REG_BIT_WIDTH = Integer.parseInt(rb.getString("GENERAL_PURPOSE_REG_BIT_WIDTH"));
        INDEX_REG_BIT_WIDTH = Integer.parseInt(rb.getString("INDEX_REG_BIT_WIDTH"));
        IAR_REG_BIT_WIDTH = Integer.parseInt(rb.getString("IAR_REG_BIT_WIDTH"));
        CC_REG_BIT_WIDTH = Integer.parseInt(rb.getString("CC_REG_BIT_WIDTH"));
        IR_REG_BIT_WIDTH = Integer.parseInt(rb.getString("IR_REG_BIT_WIDTH"));
        MAR_REG_BIT_WIDTH = Integer.parseInt(rb.getString("MAR_REG_BIT_WIDTH"));
        MBR_REG_BIT_WIDTH = Integer.parseInt(rb.getString("MBR_REG_BIT_WIDTH"));
        MSR_REG_BIT_WIDTH = Integer.parseInt(rb.getString("MSR_REG_BIT_WIDTH"));
        MFR_REG_BIT_WIDTH = Integer.parseInt(rb.getString("MFR_REG_BIT_WIDTH"));
        OPERATION_CODE_BIT_WIDTH = Integer.parseInt(rb.getString("OPERATION_CODE_BIT_WIDTH"));
        INSTRUCTION_START_ADDRESS = Integer.parseInt(rb.getString("INSTRUCTION_START_ADDRESS"));
        ROM_BOOT_FILE_PATH = rb.getString("ROM_BOOT_FILE_PATH");
        SIMULATOR_NAME = rb.getString("SIMULATOR_NAME");
    }

    public static final int WORD_BIT_WIDTH;
    public static final int DRAM_WORD_SIZE;
    public static final int GENERAL_PURPOSE_REG_BIT_WIDTH;
    public static final int INDEX_REG_BIT_WIDTH;
    public static final int IAR_REG_BIT_WIDTH;
    public static final int CC_REG_BIT_WIDTH;
    public static final int IR_REG_BIT_WIDTH;
    public static final int MAR_REG_BIT_WIDTH;
    public static final int MBR_REG_BIT_WIDTH;
    public static final int MSR_REG_BIT_WIDTH;
    public static final int MFR_REG_BIT_WIDTH;
    public static final int OPERATION_CODE_BIT_WIDTH;
    public static final int INSTRUCTION_START_ADDRESS;
    public static final String ROM_BOOT_FILE_PATH;
    public static final String SIMULATOR_NAME;


}
