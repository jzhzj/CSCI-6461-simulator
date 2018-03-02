package com.gwu.cs6461.services.instruction.transfer;


import com.gwu.cs6461.services.cpu.alu.cc.ConditionCode;
import com.gwu.cs6461.services.cpu.registers.CCRImpl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * JCC Instruction
 * Jump If Condition Code
 */
public class JCCImpl extends TransferImpl {
    boolean ccBit;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            getBit();

            if (ccBit) {
                //PC <- EA
                IARImpl.getInstance().write(effectiveAddress);
            }
        };
        return task;
    }

    private void getBit() {
        String instructionBinary = toDRAMData().getBinaryValue();

        switch (StringUtils.substring(instructionBinary, 6, 8)) {
            case "00":
                // 00
                ccBit = CCRImpl.getInstance().read().getBit(ConditionCode.Type.OVER_FLOW);
                break;
            case "01":
                // 01
                ccBit = CCRImpl.getInstance().read().getBit(ConditionCode.Type.UNDER_FLOW);
                break;
            case "10":
                // 02
                ccBit = CCRImpl.getInstance().read().getBit(ConditionCode.Type.DIV_ZERO);
                break;
            case "11":
                // 03
                ccBit = CCRImpl.getInstance().read().getBit(ConditionCode.Type.EQ_OR_NOT);
                break;
            default:
                // TODO throw machine fault

        }
    }
}
