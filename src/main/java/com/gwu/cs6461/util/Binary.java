package com.gwu.cs6461.util;

/**
 * Defines what a Binary ADT does
 */
public interface Binary {
    int getDecimalValue();
    String getBinary();
    String getHex();

    void setValue(int literalValue) throws IllegalArgumentException;
//    void setValue(String literalValue);

}
