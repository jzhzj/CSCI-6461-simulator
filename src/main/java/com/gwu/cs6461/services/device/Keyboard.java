package com.gwu.cs6461.services.device;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.util.Binary;

import java.util.Observable;

public class Keyboard extends Observable implements Device {
    private static Keyboard ourInstance = new Keyboard();

    public static Keyboard getInstance() {
        return ourInstance;
    }

    private Keyboard() {
    }

    @Override
    public void write(Binary inputBuffer) {

    }

    @Override
    public DRAMData read() {
        // TODO to be implemented
        setChanged();
        notifyObservers();
        return null;
    }
}
