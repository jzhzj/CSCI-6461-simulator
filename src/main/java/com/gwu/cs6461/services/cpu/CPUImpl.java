package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.cpu.ctrlu.ControlUnitImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.fault.IllegalOperationCode;
import com.gwu.cs6461.services.instruction.Instruction;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 * Singleton
 * CPU
 */
public class CPUImpl extends Observable implements CPU {

    private static CPUImpl ourInstance = new CPUImpl();

    public static CPUImpl getInstance() {
        return ourInstance;
    }

    private CPUImpl() {
        registers = new HashSet<>();
        registers.add(MARImpl.getInstance());
        registers.add(MBRImpl.getInstance());
        registers.add(MFRImpl.getInstance());
        registers.add(MSRImpl.getInstance());
        registers.add(CCRImpl.getInstance());
        registers.add(GPR0Impl.getInstance());
        registers.add(GPR1Impl.getInstance());
        registers.add(GPR2Impl.getInstance());
        registers.add(GPR3Impl.getInstance());
        registers.add(IARImpl.getInstance());
        registers.add(IDXR1Impl.getInstance());
        registers.add(IDXR2Impl.getInstance());
        registers.add(IDXR3Impl.getInstance());
        registers.add(IRImpl.getInstance());
    }

    public Set<Register> getRegisters() {
        return registers;
    }

    private Set<Register> registers;

    private boolean stop = true;

    @Override
    public void resume() throws IllegalOperationCode {
        stop = false;
        while(!stop){
            process();
        }
    }

    @Override
    public void pause() {
        stop = true;
        // notify halt.
        setChanged();
        notifyObservers();
    }

    @Override
    public void pauseAfter(int step) throws IllegalOperationCode {
        for(int i = 0; i < step; i++){
            process();
        }
    }


    @Override
    public void reset() {
        // stop without notifying halt.
        stop = true;
        registers.stream().forEach(register -> register.reset());
    }

    /**
     * CPU processes 1 instruction at current machine state
     */
    private void process() throws IllegalOperationCode {
        // pc
        DRAMAddress dramAddress = IARImpl.getInstance().read();
        Instruction instruction = null;
        instruction = DRAMImpl.getInstance().read(dramAddress).toInstruction();
        ControlUnitImpl.getInstance().scheduleTask(instruction);

    }
}
