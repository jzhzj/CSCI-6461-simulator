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
    String getBinary();

    /**
     * Get hex value
     * @return hex in formatted String
     */
    String getHex();

    /**
     * Modify binary value
     * @param literalValue
     * @return the Binary object itself
     * @throws IllegalArgumentException
     */
    Binary setValue(int literalValue) throws IllegalArgumentException;
//    void setValue(String literalValue);

}
