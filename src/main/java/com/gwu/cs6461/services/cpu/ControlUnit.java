package com.gwu.cs6461.services.cpu;

/**
 * Defines what control unit does: decode and fetch instructions
 */
public interface ControlUnit {
    void fetch();
    void decode();
    void execute();
}
