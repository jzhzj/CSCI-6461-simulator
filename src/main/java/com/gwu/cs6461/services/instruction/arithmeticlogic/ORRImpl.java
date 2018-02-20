package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * ORR Instruction
 * Logical Or of Register and Register
 */
public class ORRImpl extends ALImpl {
    Register<DRAMData> gpRegister2;

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            //Logical Or of Register and Register
            gpRegister.write(ALUImpl.getInstance().or(gpRegister.read(), gpRegister2.read()));

        };
        return task;
    }


    private Register getRegister2() {
        String instructionBinary = toDRAMData().getBinaryValue();

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
        return gpRegister2;
    }
}
