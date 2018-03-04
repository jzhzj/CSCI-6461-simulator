package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.IDXR1Impl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.Instruction;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;

import static junit.framework.TestCase.assertEquals;

/**
 * LDX x, address[,I]
 * Load Index Register from Memory, x = 1..3
 * Xx <- c(EA)
 */
public class LDXImplTest {

    private Instruction ldx;

    @Before
    public void setUp() throws Exception {
        ldx = new LDXImpl();
        IDXR1Impl.getInstance().write(new DRAMAddressImpl().setDecimalValue(1));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(32), new DRAMDataImpl().setDecimalValue(8));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(39), new DRAMDataImpl().setDecimalValue(888));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(888), new DRAMDataImpl().setDecimalValue(9));
    }

    @After
    public void tearDown() throws Exception {
        IDXR1Impl.getInstance().reset();
        DRAMImpl.getInstance().reset();
    }

//    @Test
    public void onExecute() {
        // LDX 1,31
        ldx.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("101001", "00", "01", "0", "11111")));
        ldx.onDecode().run();
        ldx.onExecute().run();
        assertEquals(8, IDXR1Impl.getInstance().read().getDecimalValue());

        // LDX 1,31
        ldx.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("101001", "00", "01", "1", "11111")));
        ldx.onDecode().run();
        ldx.onExecute().run();
        assertEquals(9, IDXR1Impl.getInstance().read().getDecimalValue());
    }
}