package com.gwu.cs6461.services.cpu.ctrlu;

import com.gwu.cs6461.constants.OpCodeProps;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestControlUnit {

    @Test
    public void testFetch(){
        DRAMImpl.getInstance().write(new DRAMAddress().setValue(0), new DRAMDataImpl().setValue(0b0000110000000000));
        IARImpl.getInstance().write(new DRAMAddress().setValue(0));
        ControlUnitImpl.getInstance().fetch();
        // PC = 1;
        assertEquals(1, IARImpl.getInstance().read().getDecimalValue());
    }

    @Test
    public void testExecute(){
//        ControlUnitImpl.getInstance().execute();
    }
}
