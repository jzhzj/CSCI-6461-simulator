package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class DRAMAddressImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private DRAMAddress dramAddress = new DRAMAddressImpl();

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
        dramAddress = new DRAMAddressImpl();
        // after dramAddress is initialized, it should have binary value of 12 zeros.
        assertEquals(MachineProps.IAR_REG_BIT_WIDTH, dramAddress.getBinaryValue().length());

        assertEquals("000000000000", dramAddress.getBinaryValue());

        dramAddress.setDecimalValue(2);
        assertEquals("000000000010", dramAddress.getBinaryValue());

        dramAddress.setDecimalValue(DRAMAddressImpl.MAX_VALUE);
        assertEquals("011111111111", dramAddress.getBinaryValue());
    }

    @Test
    public void getHex() {
        dramAddress = new DRAMAddressImpl();
        // after dramAddress is initialized, it should have hex value of 3 zeros.
        assertEquals(MachineProps.IAR_REG_BIT_WIDTH * 2 / Byte.SIZE, dramAddress.getHexValue().length());

        assertEquals("000", dramAddress.getHexValue());

        dramAddress.setDecimalValue(10);
        assertEquals("00a", dramAddress.getHexValue());

        dramAddress.setDecimalValue(DRAMAddressImpl.MAX_VALUE);
        assertEquals("7ff", dramAddress.getHexValue());
    }

    @Test
    public void setValue() {
        dramAddress.setDecimalValue(DRAMAddressImpl.MIN_VALUE);
        dramAddress.setDecimalValue(DRAMAddressImpl.MAX_VALUE);
    }

    @Test
    public void testSetValueAboveRange(){
        thrown.expect(IllegalArgumentException.class);
        dramAddress.setDecimalValue(DRAMAddressImpl.MAX_VALUE + 1);
    }

    @Test
    public void testSetValueBelowRange() {
        thrown.expect(IllegalArgumentException.class);
        dramAddress.setDecimalValue(DRAMAddressImpl.MIN_VALUE - 1);
    }
}