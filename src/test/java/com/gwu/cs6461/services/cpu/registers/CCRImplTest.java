package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.cpu.alu.cc.ConditionCode;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CCRImplTest {

    @Test
    public void write() {
        CCRImpl.getInstance().read().setBit(ConditionCode.Type.EQ_OR_NOT, true);
        assertTrue(CCRImpl.getInstance().read().getBit(ConditionCode.Type.EQ_OR_NOT));
    }

    @Test
    public void read() {

    }

    @Test
    public void reset() {
        CCRImpl.getInstance().reset();
        assertFalse(CCRImpl.getInstance().read().getBit(ConditionCode.Type.EQ_OR_NOT));
    }
}