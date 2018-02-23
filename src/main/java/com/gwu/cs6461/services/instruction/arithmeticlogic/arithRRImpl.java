package com.gwu.cs6461.services.instruction.arithmeticlogic;

import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.InstructionImpl;
import org.apache.commons.lang3.StringUtils;

public class arithRRImpl extends InstructionImpl {
    Register<DRAMData> gpRegister;
    Register<DRAMData> gpRegister2;

    @Override
    public Runnable onDecode() {
        Runnable decodeTask = () -> {
            // set target registers
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

            switch (StringUtils.substring(instructionBinary, 8, 10)) {
                case "00":
                    // 00
                    gpRegister2 = GPR0Impl.getInstance();
                    break;
                case "01":
                    // 01
                    gpRegister2 = GPR1Impl.getInstance();
                    break;
                case "10":
                    // 02
                    gpRegister2 = GPR2Impl.getInstance();
                    break;
                case "11":
                    // 03
                    gpRegister2 = GPR3Impl.getInstance();
                    break;
                default:
                    // TODO throw machine fault
            }
        };

        return decodeTask;
    }
}
