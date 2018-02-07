package com.gwu.cs6461.services.dram;

import com.gwu.cs6461.constants.MachineProps;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class DRAMDataImplTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private DRAMDataImpl dramData = new DRAMDataImpl();

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
        dramData = new DRAMDataImpl();
        // after dramData is initialized, it should have binary value of 16 zeros.

        assertEquals(MachineProps.WORD_BIT_WIDTH, dramData.getBinaryValue().length());

        assertEquals("0000000000000000", dramData.getBinaryValue());

        dramData.setDecimalValue(2);
        assertEquals("0000000000000010", dramData.getBinaryValue());

        dramData.setDecimalValue(-2);
        assertEquals("1111111111111110", dramData.getBinaryValue());

        dramData.setDecimalValue(1823);
        assertEquals("0000011100011111", dramData.getBinaryValue());
    }

    @Test
    public void getHex() {
        dramData = new DRAMDataImpl();
        // after dramData is initialized, it should have hex value of 4 zeros.

        assertEquals(MachineProps.WORD_BIT_WIDTH / Byte.SIZE * 2, dramData.getHexValue().length());

        assertEquals("0000", dramData.getHexValue());

        dramData.setDecimalValue(10);
        assertEquals("000a", dramData.getHexValue());

        dramData.setDecimalValue(-2);
        assertEquals("fffe", dramData.getHexValue());
    }

    @Test
    public void setValue() {
        dramData.setDecimalValue(DRAMDataImpl.MIN_VALUE);
        dramData.setDecimalValue(DRAMDataImpl.MAX_VALUE);
    }

    @Test
    public void testSetValueAboveRange(){
        thrown.expect(IllegalArgumentException.class);
        dramData.setDecimalValue(DRAMDataImpl.MAX_VALUE + 1);
    }

    @Test
    public void testSetValueBelowRange(){
        thrown.expect(IllegalArgumentException.class);
        dramData.setDecimalValue(DRAMDataImpl.MIN_VALUE - 1);
    }
}