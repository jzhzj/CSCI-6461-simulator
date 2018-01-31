package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class TestDRAMData {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private DRAMData dramData = new DRAMData();

    @Test
    public void testSetValueInRange() {
        dramData.setValue(DRAMData.MIN_VALUE);
        dramData.setValue(DRAMData.MAX_VALUE);
    }

    @Test
    public void testSetValueAboveRange(){
        thrown.expect(IllegalArgumentException.class);
        dramData.setValue(DRAMData.MAX_VALUE + 1);
    }

    @Test
    public void testSetValueBelowRange(){
        thrown.expect(IllegalArgumentException.class);
        dramData.setValue(DRAMData.MIN_VALUE - 1);
    }

//    @Test
    public void testGetBinary() {
        dramData = new DRAMData();
        // after dramData is initialized, it should have binary value of 16 zeros.

        assertEquals(MachineProps.WORD_BIT_WIDTH, dramData.getBinary().length());

        assertEquals("0000000000000000", dramData.getBinary());

        dramData.setValue(2);
        assertEquals("0000000000000010", dramData.getBinary());

        dramData.setValue(-2);
        assertEquals("1111111111111110", dramData.getBinary());
    }

//    @Test
    public void testGetHex() {
        dramData = new DRAMData();
        // after dramData is initialized, it should have binary value of 16 zeros.

        assertEquals(MachineProps.WORD_BIT_WIDTH / Byte.SIZE * 2, dramData.getHex().length());

        assertEquals("0000", dramData.getHex());

        dramData.setValue(2);
        assertEquals("0002", dramData.getHex());

        dramData.setValue(-2);
        assertEquals("fff2", dramData.getHex());
    }
}
