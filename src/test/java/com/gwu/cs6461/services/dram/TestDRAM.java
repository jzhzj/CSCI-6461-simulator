package com.gwu.cs6461.services.dram;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDRAM {

    @Test
    public void testRead(){
        assertEquals(0, DRAMImpl.getInstance().read(new DRAMAddress().setValue(DRAMAddress.MIN_VALUE)).getDecimalValue());
        assertEquals(0, DRAMImpl.getInstance().read(new DRAMAddress().setValue(DRAMAddress.MAX_VALUE)).getDecimalValue());
    }

    @Test
    public void testWrite(){
        DRAMImpl.getInstance().write(new DRAMAddress().setValue(1), new DRAMData().setValue(-1));
        DRAMImpl.getInstance().write(new DRAMAddress().setValue(1), new DRAMData().setValue(1));
        assertEquals(1, DRAMImpl.getInstance().read(new DRAMAddress().setValue(1)).getDecimalValue());
    }

    @Test
    public void testReset(){
        DRAMImpl.getInstance().reset();
        testRead();
    }
}
