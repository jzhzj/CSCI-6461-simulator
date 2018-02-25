package com.gwu.cs6461.services.sram;

import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SRAMImplTest {

    @Before
    public void setUp() throws Exception {
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(10), new DRAMDataImpl().setDecimalValue(110));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(15), new DRAMDataImpl().setDecimalValue(115));
        DRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(18), new DRAMDataImpl().setDecimalValue(118));
    }


    @Test
    public void read() {
        assertEquals(110, SRAMImpl.getInstance().read(new DRAMAddressImpl().setDecimalValue(10)).getDecimalValue());
        assertEquals(115, SRAMImpl.getInstance().read(new DRAMAddressImpl().setDecimalValue(15)).getDecimalValue());
        assertEquals(118, SRAMImpl.getInstance().read(new DRAMAddressImpl().setDecimalValue(18)).getDecimalValue());
    }

    @Test
    public void write() {
        SRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(10), new DRAMDataImpl().setDecimalValue(110));
        SRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(10), new DRAMDataImpl().setDecimalValue(111));
        SRAMImpl.getInstance().write(new DRAMAddressImpl().setDecimalValue(10), new DRAMDataImpl().setDecimalValue(112));

        assertEquals(112, SRAMImpl.getInstance().read(new DRAMAddressImpl().setDecimalValue(10)).getDecimalValue());
    }

    @Test
    public void readLowerLevel() {
    }


    @Test
    public void writeLowerLevel() {
    }
}