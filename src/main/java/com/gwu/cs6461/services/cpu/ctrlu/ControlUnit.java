package com.gwu.cs6461.services.cpu.ctrlu;


/**
 * Defines what control unit does: fetch, decode and execute instructions
 */
public interface ControlUnit {

    void fetch();

    void decode();

    void execute();

}
