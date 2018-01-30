package com.gwu.cs6461.services.cpu;

import com.gwu.cs6461.services.cpu.alu.ALU;
import com.gwu.cs6461.services.cpu.alu.ALUImpl;
import com.gwu.cs6461.services.cpu.ctrlu.ControlUnit;
import com.gwu.cs6461.services.cpu.ctrlu.ControlUnitImpl;
import com.gwu.cs6461.services.cpu.registers.*;

public class CPUImpl implements CPU{

    private ALU alu = new ALUImpl();
    private ControlUnit controlUnit = new ControlUnitImpl();

    // 4 General Purpose Registers
    private GPRImpl gp_reg_0 = new GPRImpl();
    private GPRImpl gp_reg_1 = new GPRImpl();
    private GPRImpl gp_reg_2 = new GPRImpl();
    private GPRImpl gp_reg_3 = new GPRImpl();

    // 3 Index Registers
    private IDXRImpl idx_reg_1 = new IDXRImpl();
    private IDXRImpl idx_reg_2 = new IDXRImpl();
    private IDXRImpl idx_reg_3 = new IDXRImpl();

    // 1 Instruction Address Register (PC)
    private IARImpl ia_reg = new IARImpl();

    // 1 Instruction Register
    private IRImpl ins_reg = new IRImpl();

    // 1 Memory Address Register
    private MARImpl ma_reg = new MARImpl();

    // 1 Memory Buffer Register
    private MBRImpl mb_reg = new MBRImpl();


}
