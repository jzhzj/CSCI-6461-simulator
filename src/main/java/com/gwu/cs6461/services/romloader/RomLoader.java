package com.gwu.cs6461.services.romloader;

/**
 * Defines what Rom Loader does
 */
public interface RomLoader {
    /**
     * Initialize DRAM and load rom data at from address 8
     */
    void boot();
}
