package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.dram.DRAMData;

/**
 * General Purpose Register
 * Accumulator register is used to perform arithmetic and logical operations.
 * It holds the initial data to be operated upon, and the final result for processing.
 * The results of arithmetic operations are returned to accumulator for transfer to the main memory through buffer register.
 */
public class GPRImpl implements Register<DRAMData>{

    private DRAMData operationResult;

    @Override
    public void write(DRAMData data) {
        operationResult = data;
    }

    @Override
    public DRAMData read() {
        return operationResult;
    }
}
