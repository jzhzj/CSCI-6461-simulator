package com.gwu.cs6461.services.instruction;

import com.gwu.cs6461.constants.ClockCycle;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.cpu.registers.IRImpl;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;

/**
 *  1st-tier Instruction implementation
 *
 */
public class InstructionImpl implements Instruction {

    private DRAMData data;

    @ClockCycle(count = 6)
    @Override
    public void onFetch() {
        // memory address : PC -> MAR
        DRAMAddress address = IARImpl.getInstance().read();
        MARImpl.getInstance().write(address);
        // read memory data using the address, then write it to MBR : M (MAR) -> MBR
        DRAMData data = DRAMImpl.getInstance().read(address);
        MBRImpl.getInstance().write(data);

        // write instruction to IR, MBR -> IR
        IRImpl.getInstance().write(data.toInstruction());
        // PC -> PC + 1
        IARImpl.getInstance().write(new DRAMAddress().setValue(IARImpl.getInstance().read().getDecimalValue() + 1));
    }

    @Override
    public void onDecode() {

    }

    @Override
    public void onExecute() {

    }

    @Override
    public Instruction fromDRAMData(DRAMData data) {
        this.data = data;
        return this;
    }

    @Override
    public DRAMData toDRAMData() {
        return data;
    }
}
