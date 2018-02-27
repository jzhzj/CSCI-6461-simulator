package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.cpu.registers.GPR2Impl;
import com.gwu.cs6461.services.cpu.registers.IDXR2Impl;
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
 * LDA r, x, address[,I]
 * Load Register with Address, r = 0..3
 * r <− EA
 */
public class LDAImplTest {

    private Instruction lda;

    @Before
    public void setUp() throws Exception {
        lda = new LDAImpl();
        IDXR2Impl.getInstance().write(new DRAMAddressImpl().setDecimalValue(1));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(32), new DRAMDataImpl().setDecimalValue(8));
    }

    @After
    public void tearDown() throws Exception {
        IDXR2Impl.getInstance().reset();
        DRAMImpl.getInstance().reset();
    }

    @Test
    public void onExecute() {
        // LDA 2,2,31
        lda.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("000011", "10", "10", "0", "11111")));
        lda.onDecode().run();
        lda.onExecute().run();
        assertEquals(32, GPR2Impl.getInstance().read().getDecimalValue());

        // LDA 2,2,31
        lda.fromDRAMData(new DRAMDataImpl().setBinaryValue(StringUtils.join("000011", "10", "10", "1", "11111")));
        lda.onDecode().run();
        lda.onExecute().run();
        assertEquals(8, GPR2Impl.getInstance().read().getDecimalValue());
    }
}