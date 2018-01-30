package com.gwu.cs6461.services.dram;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestDRAMAddress {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private DRAMAddress dramAddress = new DRAMAddress();

    @Test
    public void testSetValueInRange(){
        dramAddress.setValue(DRAMAddress.MIN_VALUE);
        dramAddress.setValue(DRAMAddress.MAX_VALUE);
    }

    @Test
    public void testSetValueAboveRange(){
        thrown.expect(IllegalArgumentException.class);
        dramAddress.setValue(DRAMAddress.MAX_VALUE + 1);
    }

    @Test
    public void testSetValueBelowRange() {
        thrown.expect(IllegalArgumentException.class);
        dramAddress.setValue(DRAMAddress.MIN_VALUE - 1);
    }

    @Test
    public void testGetBinary() {
        dramAddress = new DRAMAddress();
        // after dramAddress is initialized, it should have binary value of 12 zeros.
    }

    @Test void testGetHex() {
        dramAddress = new DRAMAddress();

    }
}
