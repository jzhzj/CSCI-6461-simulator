package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.GPR3Impl;
import com.gwu.cs6461.services.cpu.registers.IDXR1Impl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.Instruction;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * LDR r, x, address[,I]
 * Load Register From Memory, r = 0..3
 * r <− c(EA)
 * r <- c(c(EA)), if I bit set
 */
public class LDRImplTest {

    private Instruction ldr;

    @Before
    public void setUp() throws Exception {
        ldr = new LDRImpl();
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(31), new DRAMDataImpl().setDecimalValue(8));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(32), new DRAMDataImpl().setDecimalValue(10));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(10), new DRAMDataImpl().setDecimalValue(100));
        IDXR1Impl.getInstance().write(new DRAMAddressImpl().setDecimalValue(1));
    }

    @After
    public void tearDown() throws Exception {
        DRAMImpl.getInstance().reset();
        IDXR1Impl.getInstance().reset();
    }

    @Test
    public void onExecute() {
        // LDR 3,0,31
        ldr.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("000001", "11", "00", "0", "11111")));
        ldr.onDecode().run();
        ldr.onExecute().run();
        assertEquals(8, GPR3Impl.getInstance().read().getDecimalValue());

        // LDR 3,1,31
//        ldr.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("000001", "11", "01", "1", "11111")));
//        ldr.onDecode().run();
//        ldr.onExecute().run();
//        assertEquals(100, GPR3Impl.getInstance().read().getDecimalValue());
    }
}