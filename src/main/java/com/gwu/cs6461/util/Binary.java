package com.gwu.cs6461.util;

/**
 * Defines what a Binary ADT does
 */
public interface Binary {
    int getDecimalValue();

    /**
     * Get binary value in 2's compliment
     * @return binary in formatted String
     */
    String getBinaryValue();

    /**
     * Get hex value
     * @return hex in formatted String
     */
    String getHexValue();

    /**
     * Modify binary value
     * @param decimalValue value as int
     * @return the Binary object itself
     * @throws IllegalArgumentException
     */
    Binary setDecimalValue(int decimalValue) throws IllegalArgumentException;

    /**
     * Modify binary value
     * @param decimalValue value as string
     * @return the Binary object itself
     * @throws IllegalArgumentException
     */
    Binary setDecimalValue(String decimalValue) throws IllegalArgumentException;

    /**
     * Modify binary value by a binary string
     * @param binaryValue binary string
     * @return the Binary object itself
     * @throws IllegalArgumentException
     */
    Binary setBinaryValue(String binaryValue) throws IllegalArgumentException;

}
