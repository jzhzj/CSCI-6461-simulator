package com.gwu.cs6461.services.cpu.alu;

import com.gwu.cs6461.services.dram.DRAMDataImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ALUImplTest {

    private ALU alu;

    @Before
    public void setUp() throws Exception {
        alu = ALUImpl.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        // 1 + 1 = 2
        assertEquals(2, alu.add(new DRAMDataImpl().setDecimalValue(1), 1).getDecimalValue());
    }

    @Test
    public void add1() {
    }

    @Test
    public void subtract() {
    }

    @Test
    public void subtract1() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }

    @Test
    public void and() {
    }

    @Test
    public void or() {
    }

    @Test
    public void not() {
    }

    @Test
    public void test1() {
    }

    @Test
    public void arithmeticShiftR() {
    }

    @Test
    public void logicalShiftL() {
    }

    @Test
    public void logicalShiftR() {
    }

    @Test
    public void logicalRotateL() {
    }

    @Test
    public void logicalRotateR() {
    }
}