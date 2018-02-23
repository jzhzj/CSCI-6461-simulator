package com.gwu.cs6461.services.device;

import com.gwu.cs6461.services.dram.DRAMData;


import java.util.Observable;

public class Keyboard extends Observable implements Device<DRAMData> {
    private static Keyboard ourInstance = new Keyboard();

    public static Keyboard getInstance() {
        return ourInstance;
    }

    private Keyboard() {
    }

    @Override
    public void write(DRAMData inputBuffer) {

    }

    @Override
    public DRAMData read() {
        // TODO to be implemented
        setChanged();
        notifyObservers();
        return null;
    }
}
