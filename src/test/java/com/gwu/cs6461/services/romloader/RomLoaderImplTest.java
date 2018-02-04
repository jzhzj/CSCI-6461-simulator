package com.gwu.cs6461.services.romloader;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomLoaderImplTest {

    @Test
    public void boot() {
        RomLoaderImpl.getInstance().boot();
    }
}