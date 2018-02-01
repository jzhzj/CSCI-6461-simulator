package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.cpu.registers.IRImpl;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.cpu.registers.MBRImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.Instruction;
import com.gwu.cs6461.services.instruction.OpCode;

import java.lang.reflect.InvocationTargetException;


/**
 * Singleton
 * Control Unit: the most important part of CPU
 */
public class ControlUnitImpl implements ControlUnit {

    private static ControlUnitImpl ourInstance = new ControlUnitImpl();

    public static ControlUnitImpl getInstance() {
        return ourInstance;
    }

    private ControlUnitImpl() {

    }

    @Override
    public void fetch() {
        // memory address : PC -> MAR
        DRAMAddress address = IARImpl.getInstance().read();
        MARImpl.getInstance().write(address);
        // read memory data using the address, then write it to MBR : M (MAR) -> MBR
        DRAMData data = DRAMImpl.getInstance().read(address);
        MBRImpl.getInstance().write(data);

        // decode data into instruction, write instruction to IR, MBR -> IR
        IRImpl.getInstance().write(this.decode(data));
        // PC -> PC + 1
        IARImpl.getInstance().write(new DRAMAddress().setValue(IARImpl.getInstance().read().getDecimalValue() + 1));
    }

    private Instruction decode(DRAMData data) {
        // determine instruction type by opcode
        Instruction instruction = null;

        try {
            String className = OpCode.getInstructionImplClassName(data);
            Class instructionImpl = Class.forName(className);
            instruction = (Instruction) instructionImpl.getConstructor().newInstance();
            instruction.fromDRAMData(data);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return instruction;
    }

    @Override
    public void execute() {
        IRImpl.getInstance().read().onExecute();
    }
}
