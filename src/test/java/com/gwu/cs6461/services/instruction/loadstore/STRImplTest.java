package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.GPR1Impl;
import com.gwu.cs6461.services.cpu.registers.IDXR1Impl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.instruction.Instruction;
import com.gwu.cs6461.services.sram.SRAMImpl;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * STR r, x, address[,I]
 * Store Register To Memory, r = 0..3
 * Memory(EA) <− c(r)
 */
public class STRImplTest {

    private Instruction str;

    @Before
    public void setUp() throws Exception {
        str = new STRImpl();
        GPR1Impl.getInstance().write(new DRAMDataImpl().setDecimalValue(888));
        IDXR1Impl.getInstance().write(new DRAMAddressImpl().setDecimalValue(1));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(888), new DRAMDataImpl().setDecimalValue(9));
    }

    @After
    public void tearDown() throws Exception {
        GPR1Impl.getInstance().reset();
    }

    @Test
    public void onExecute() {
        // STR 1,1,31
        str.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("000010", "01", "01", "0", "11111")));
        str.onDecode().run();
        str.onExecute().run();
        // EA = 31 + 1
        assertEquals(888, SRAMImpl.getInstance().read(new DRAMAddressImpl().setDecimalValue(32)).getDecimalValue());

        // STR 1,1,31
        str.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("000010", "01", "01", "1", "11111")));
        str.onDecode().run();
        str.onExecute().run();
        // EA = 888
        assertEquals(888, SRAMImpl.getInstance().read(new DRAMAddressImpl().setDecimalValue(888)).getDecimalValue());

    }
}