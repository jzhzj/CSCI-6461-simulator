package com.gwu.cs6461.services.cpu.registers;

/**
 * Defines what register does
 */
public interface Register<T> {

    /**
     * Write data to register
     * @param data data to be written to register
     */
    void write(T data);

    /**
     * Read data from register
     * @return data in register
     */
    T read();

    /**
     * Reset register, clear data
     */
    void reset();
}
