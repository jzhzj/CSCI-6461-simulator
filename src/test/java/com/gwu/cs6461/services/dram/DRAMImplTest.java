package com.gwu.cs6461.services.dram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class DRAMImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void read() {
        assertEquals(0, DRAMImpl.getInstance().read(new DRAMAddress().setValue(DRAMAddress.MIN_VALUE)).getDecimalValue());
        assertEquals(0, DRAMImpl.getInstance().read(new DRAMAddress().setValue(DRAMAddress.MAX_VALUE)).getDecimalValue());
    }

    @Test
    public void write() {
        DRAMImpl.getInstance().write(new DRAMAddress().setValue(1), new DRAMDataImpl().setValue(-1));
        DRAMImpl.getInstance().write(new DRAMAddress().setValue(1), new DRAMDataImpl().setValue(1));
        assertEquals(1, DRAMImpl.getInstance().read(new DRAMAddress().setValue(1)).getDecimalValue());
    }

    @Test
    public void reset() {
        DRAMImpl.getInstance().reset();
        read();
    }
}