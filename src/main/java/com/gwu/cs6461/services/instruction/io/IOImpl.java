package com.gwu.cs6461.services.instruction.io;

import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.device.Device;
import com.gwu.cs6461.services.device.Keyboard;
import com.gwu.cs6461.services.device.Printer;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.instruction.InstructionImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * IO Instruction
 * super class of all IO instructions
 */
public class IOImpl extends InstructionImpl {

    Register<DRAMData> gpRegister;
    Device<DRAMData> ioDevice;

    @Override
    public Runnable onDecode() {
        Runnable task = () -> {
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

            switch (StringUtils.substring(instructionBinary, 11, 16)) {
                case "00000":
                    // device id 0
                    ioDevice = Keyboard.getInstance();
                    break;
                case "00001":
                    // device id 1
                    ioDevice = Printer.getInstance();
                    break;
                default:
                    // TODO throw machine fault

            }
        };
        return task;
    }
}
