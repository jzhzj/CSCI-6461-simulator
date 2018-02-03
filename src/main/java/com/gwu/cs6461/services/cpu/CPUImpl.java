package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.cpu.registers.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Singleton
 * CPU
 */
public class CPUImpl implements CPU{

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

    private Set<Register> registers;

    @Override
    public void reset() {
        registers.stream().forEach(register -> register.reset());
    }
}
