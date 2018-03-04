package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControlUnitImplTest {

    @Before
    public void setUp() throws Exception {
        DRAMAddress dramAddress = new DRAMAddressImpl().setDecimalValue(10);
        DRAMImpl.getInstance().write(dramAddress, new DRAMDataImpl().setDecimalValue(0b0000110000000000));
        IARImpl.getInstance().write(dramAddress);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fetch() {

//        ControlUnitImpl.getInstance().fetch();
        // PC = 1;
//        assertEquals(1, IARImpl.getInstance().read().getDecimalValue());
    }

    @Test
    public void decode() {

    }

    @Test
    public void execute() {

    }
}