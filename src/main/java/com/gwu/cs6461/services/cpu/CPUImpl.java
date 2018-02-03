package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.cpu.registers.*;

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

    }

    @Override
    public void reset() {

        MARImpl.getInstance().reset();
        MBRImpl.getInstance().reset();
        MFRImpl.getInstance().reset();
        MSRImpl.getInstance().reset();
        CCRImpl.getInstance().reset();
        GPR0Impl.getInstance().reset();
        GPR1Impl.getInstance().reset();
        GPR2Impl.getInstance().reset();
        GPR3Impl.getInstance().reset();
        IARImpl.getInstance().reset();
        IDXR1Impl.getInstance().reset();
        IDXR2Impl.getInstance().reset();
        IDXR3Impl.getInstance().reset();
        IRImpl.getInstance().reset();


    }
}
