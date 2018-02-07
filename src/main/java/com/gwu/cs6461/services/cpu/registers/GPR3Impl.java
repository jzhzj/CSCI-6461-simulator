package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

import java.util.Observable;

/**
 * General Purpose Register 3
 * Accumulator register is used to perform arithmetic and logical operations.
 * It holds the initial data to be operated upon, and the final result for processing.
 * The results of arithmetic operations are returned to accumulator for transfer to the main memory through buffer register.
 */
public class GPR3Impl extends Observable implements Register<DRAMData>{

    private static GPR3Impl ourInstance = new GPR3Impl();

    public static GPR3Impl getInstance() {
        return ourInstance;
    }

    private GPR3Impl() {

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
