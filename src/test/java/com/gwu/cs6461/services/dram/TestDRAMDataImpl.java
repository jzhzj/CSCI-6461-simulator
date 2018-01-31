package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class TestDRAMDataImpl {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private DRAMDataImpl dramData = new DRAMDataImpl();

    @Test
    public void testSetValueInRange() {
        dramData.setValue(DRAMDataImpl.MIN_VALUE);
        dramData.setValue(DRAMDataImpl.MAX_VALUE);
    }

    @Test
    public void testSetValueAboveRange(){
        thrown.expect(IllegalArgumentException.class);
        dramData.setValue(DRAMDataImpl.MAX_VALUE + 1);
    }

    @Test
    public void testSetValueBelowRange(){
        thrown.expect(IllegalArgumentException.class);
        dramData.setValue(DRAMDataImpl.MIN_VALUE - 1);
    }

    @Test
    public void testGetBinary() {
        dramData = new DRAMDataImpl();
        // after dramData is initialized, it should have binary value of 16 zeros.

        assertEquals(MachineProps.WORD_BIT_WIDTH, dramData.getBinary().length());

        assertEquals("0000000000000000", dramData.getBinary());

        dramData.setValue(2);
        assertEquals("0000000000000010", dramData.getBinary());

        dramData.setValue(-2);
        assertEquals("1111111111111110", dramData.getBinary());
    }

    @Test
    public void testGetHex() {
        dramData = new DRAMDataImpl();
        // after dramData is initialized, it should have hex value of 4 zeros.

        assertEquals(MachineProps.WORD_BIT_WIDTH / Byte.SIZE * 2, dramData.getHex().length());

        assertEquals("0000", dramData.getHex());

        dramData.setValue(10);
        assertEquals("000a", dramData.getHex());

        dramData.setValue(-2);
        assertEquals("fffe", dramData.getHex());
    }
}
