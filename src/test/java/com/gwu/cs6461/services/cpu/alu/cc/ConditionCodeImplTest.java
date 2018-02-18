package com.gwu.cs6461.services.cpu.alu.cc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConditionCodeImplTest {

    private ConditionCode cc;

    @Before
    public void setUp() throws Exception {
        cc = new ConditionCodeImpl();
        cc.setBit(ConditionCode.Type.UNDER_FLOW, true);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBit() {
        assertTrue(cc.getBit(ConditionCode.Type.UNDER_FLOW));
        assertEquals("0100", cc.toString());
    }

    @Test
    public void setBit() {
        cc.setBit(ConditionCode.Type.OVER_FLOW, true);
        cc.setBit(ConditionCode.Type.UNDER_FLOW, false);
        assertEquals("1000", cc.toString());
    }
}