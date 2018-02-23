package com.gwu.cs6461.services.instruction.arithmeticlogic;

import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.InstructionImpl;
import org.apache.commons.lang3.StringUtils;

public class arithRCImpl extends InstructionImpl {
    Register<DRAMData> gpRegister;
    boolean isLogical;
    boolean isLeft;
    int count;

    @Override
    public Runnable onDecode() {
        Runnable decodeTask = () -> {
            // set target register and count
            String instructionBinary = toDRAMData().getBinaryValue();

            switch (StringUtils.substring(instructionBinary, 6, 8)) {
                case "00":
                    // 00
                    gpRegister = GPR0Impl.getInstance();
                    break;
                case "01":
                    // 01
                    gpRegister = GPR1Impl.getInstance();
                    break;
                case "10":
                    // 02
                    gpRegister = GPR2Impl.getInstance();
                    break;
                case "11":
                    // 03
                    gpRegister = GPR3Impl.getInstance();
                    break;
                default:
                    // TODO throw machine fault

            }

            switch (StringUtils.substring(instructionBinary, 8, 9)) {
                case "0":
                    //0
                    isLogical = false;
                    break;
                case "1":
                    //1
                    isLogical = true;
                    break;
                default:
                    //TODO throw machine fault
            }

            switch (StringUtils.substring(instructionBinary, 9, 10)) {
                case "0":
                    //0
                    isLeft = false;
                    break;
                case "1":
                    //1
                    isLeft = true;
                    break;
                default:
                    //TODO throw machine fault
            }

            count = Integer.parseInt(StringUtils.substring(instructionBinary, 12, 16));
        };

        return decodeTask;
    }
}
