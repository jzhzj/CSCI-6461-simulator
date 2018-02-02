package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class DRAMAddressTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private DRAMAddress dramAddress = new DRAMAddress();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDecimalValue() {
    }

    @Test
    public void getBinary() {
        dramAddress = new DRAMAddress();
        // after dramAddress is initialized, it should have binary value of 12 zeros.
        assertEquals(MachineProps.IAR_REG_BIT_WIDTH, dramAddress.getBinary().length());

        assertEquals("000000000000", dramAddress.getBinary());

        dramAddress.setValue(2);
        assertEquals("000000000010", dramAddress.getBinary());

        dramAddress.setValue(DRAMAddress.MAX_VALUE);
        assertEquals("111111111111", dramAddress.getBinary());
    }

    @Test
    public void getHex() {
        dramAddress = new DRAMAddress();
        // after dramAddress is initialized, it should have hex value of 3 zeros.
        assertEquals(MachineProps.IAR_REG_BIT_WIDTH * 2 / Byte.SIZE, dramAddress.getHex().length());

        assertEquals("000", dramAddress.getHex());

        dramAddress.setValue(10);
        assertEquals("00a", dramAddress.getHex());

        dramAddress.setValue(DRAMAddress.MAX_VALUE);
        assertEquals("fff", dramAddress.getHex());
    }

    @Test
    public void setValue() {
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
}