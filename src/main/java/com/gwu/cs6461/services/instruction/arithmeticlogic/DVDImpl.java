package com.gwu.cs6461.services.instruction.arithmeticlogic;


import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMData;
import org.apache.commons.lang3.StringUtils;

/**
 * DVD Instruction
 * Divide Register by Register
 */
public class DVDImpl extends arithRRImpl {

    @Override
    public Runnable onExecute() {
        Runnable task = () -> {
            if (gpRegister == GPR1Impl.getInstance() || gpRegister2 == GPR1Impl.getInstance() || gpRegister == GPR3Impl.getInstance() || gpRegister2 == GPR3Impl.getInstance()) {
                //TODO throw machine fault
            }
            // c(rx) / c(ry)
            DRAMData[] dramData = (DRAMData[]) ALUImpl.getInstance().divide(gpRegister.read(), gpRegister2.read());
            // rx <- quotient
            gpRegister.write(dramData[0]);
            // rx+1 <- remainder
            if (gpRegister == GPR0Impl.getInstance()) {
                GPR1Impl.getInstance().write(dramData[1]);
            } else {
                GPR3Impl.getInstance().write(dramData[1]);
            }
        };
        return task;
    }
}
