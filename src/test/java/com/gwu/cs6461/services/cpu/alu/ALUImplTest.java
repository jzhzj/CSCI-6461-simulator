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
        assertEquals(-100, alu.subtract(new DRAMDataImpl().setDecimalValue(300), new DRAMDataImpl().setDecimalValue(400)).getDecimalValue());
    }

    @Test
    public void subtract1() {
    }

    @Test
    public void multiply() {
        assertEquals(1526, alu.multiply(new DRAMDataImpl().setDecimalValue(10001), new DRAMDataImpl().setDecimalValue(10001))[0].getDecimalValue());
        assertEquals(12065, alu.multiply(new DRAMDataImpl().setDecimalValue(10001), new DRAMDataImpl().setDecimalValue(10001))[1].getDecimalValue());
    }

    @Test
    public void divide() {
        assertEquals(256, alu.divide(new DRAMDataImpl().setDecimalValue(10001), new DRAMDataImpl().setDecimalValue(39))[0].getDecimalValue());
        assertEquals(17, alu.divide(new DRAMDataImpl().setDecimalValue(10001), new DRAMDataImpl().setDecimalValue(39))[1].getDecimalValue());
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
        assertEquals(68, alu.arithmeticShiftR(new DRAMDataImpl().setDecimalValue(136),1).getDecimalValue());
    }

    @Test
    public void logicalShiftL() {
        assertEquals(10, alu.logicalShiftL(new DRAMDataImpl().setDecimalValue(5),1).getDecimalValue());
    }

    @Test
    public void logicalShiftR() {
        assertEquals(-16, alu.logicalShiftR(new DRAMDataImpl().setDecimalValue(-32),1).getDecimalValue());
    }

    @Test
    public void logicalRotateL() {
        assertEquals(1, alu.logicalRotateL(new DRAMDataImpl().setDecimalValue(16384), 2).getDecimalValue());
    }

    @Test
    public void logicalRotateR() {
        assertEquals(16384, alu.logicalRotateR(new DRAMDataImpl().setDecimalValue(1), 2).getDecimalValue());
    }
}