package com.gwu.cs6461.services.cpu.ctrlu;


/**
 * Defines what control unit does: decode and fetch instructions
 * TODO need more detailed design.
 */
public interface ControlUnit {

    void fetch();

    void execute();

}
