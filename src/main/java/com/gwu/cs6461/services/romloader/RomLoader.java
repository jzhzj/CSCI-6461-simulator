package com.gwu.cs6461.services.romloader;

import com.gwu.cs6461.constants.MachineProps;

/**
 * Defines what Rom Loader does
 */
public interface RomLoader {
    String BOOT_FILE_PATH = MachineProps.ROM_BOOT_FILE_PATH;

    /**
     * Initialize DRAM and load rom data at from address 8
     */
    void boot();
}
