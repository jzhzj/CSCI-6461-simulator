package com.gwu.cs6461.services.instruction;

import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.cpu.registers.IRImpl;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.sram.SRAMImpl;

/**
 * 1st-tier Instruction implementation
 */
public class InstructionImpl implements Instruction {

    private DRAMData data;

    @Override
    public Runnable onFetch() {
        Runnable fetchTask = () -> {
            // memory address : PC -> MAR
            DRAMAddress address = IARImpl.getInstance().read();
            MARImpl.getInstance().write(address);
            // read memory data using the address, then write it to MBR : M (MAR) -> MBR
            DRAMData data = SRAMImpl.getInstance().read(address);
            MBRImpl.getInstance().write(data);

            // write instruction to IR, MBR -> IR
            IRImpl.getInstance().write(data);
            // PC -> PC + 1
            IARImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(ALUImpl.getInstance().add(IARImpl.getInstance().read(), 1).getDecimalValue()));
        };
        return fetchTask;
    }

    @Override
    public Runnable onDecode() {
        return null;
    }

    @Override
    public Runnable onExecute() {
        return null;
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
