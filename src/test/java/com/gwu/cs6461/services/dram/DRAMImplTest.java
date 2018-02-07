package com.gwu.cs6461.services.dram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DRAMImplTest {

    @Before
    public void setUp() throws Exception {
        DRAMImpl.getInstance().reset();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void read() {
        assertEquals(0, DRAMImpl.getInstance().read(new DRAMAddress().setDecimalValue(DRAMAddress.MIN_VALUE)).getDecimalValue());
        assertEquals(0, DRAMImpl.getInstance().read(new DRAMAddress().setDecimalValue(DRAMAddress.MAX_VALUE)).getDecimalValue());
    }

    @Test
    public void write() {
        DRAMImpl.getInstance().write(new DRAMAddress().setDecimalValue(1), new DRAMDataImpl().setDecimalValue(-1));
        DRAMImpl.getInstance().write(new DRAMAddress().setDecimalValue(1), new DRAMDataImpl().setDecimalValue(1));
        assertEquals(1, DRAMImpl.getInstance().read(new DRAMAddress().setDecimalValue(1)).getDecimalValue());
    }

    @Test
    public void reset() {
        DRAMImpl.getInstance().reset();
        read();
    }
}