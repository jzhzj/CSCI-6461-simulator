package com.gwu.cs6461.services.romloader;

/**
 * Singleton
 * Rom Loader
 */
public class RomLoaderImpl implements RomLoader{

    private static RomLoaderImpl ourInstance = new RomLoaderImpl();

    public static RomLoaderImpl getInstance() {
        return ourInstance;
    }

    private RomLoaderImpl() {

    }

    @Override
    public void load() {

    }
}
