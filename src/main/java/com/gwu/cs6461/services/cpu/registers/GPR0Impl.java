package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

import java.util.Observable;

/**
 * Singleton
 * General Purpose Register 0
 * Accumulator register is used to perform arithmetic and logical operations.
 * It holds the initial data to be operated upon, and the final result for processing.
 * The results of arithmetic operations are returned to accumulator for transfer to the main memory through buffer register.
 *
 */
public class GPR0Impl extends Observable implements Register<DRAMData>{

    private static GPR0Impl ourInstance = new GPR0Impl();

    public static GPR0Impl getInstance() {
        return ourInstance;
    }

    private GPR0Impl() {

    }

    private DRAMData operationResult;

    @Override
    public void write(DRAMData data) {
        operationResult = data;
        setChanged();
        notifyObservers();
    }

    @Override
    public DRAMData read() {
        return operationResult;
    }

    @Override
    public void reset() {
        write(new DRAMDataImpl().setDecimalValue(0));
    }
}
