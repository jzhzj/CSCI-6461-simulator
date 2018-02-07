package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

import java.util.Observable;

/**
 * Singleton
 * Instruction Register
 * It holds the current instruction that is being executed
 */
public class IRImpl extends Observable implements Register<DRAMData>{

    private static IRImpl ourInstance = new IRImpl();

    public static IRImpl getInstance() {
        return ourInstance;
    }

    private IRImpl() {

    }

    private DRAMData currentIns;

    @Override
    public void write(DRAMData data) {
        currentIns = data;
        setChanged();
        notifyObservers();
    }

    @Override
    public DRAMData read() {
        return currentIns;
    }

    @Override
    public void reset() {
        write(new DRAMDataImpl().setDecimalValue(0));
    }
}
