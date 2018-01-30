package com.gwu.cs6461.services.dram;

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

    @Test
    public void testGetBinary() {
        dramData = new DRAMData();
        assertEquals(dramData.getBinary(), "0000000000000000");
    }
}
