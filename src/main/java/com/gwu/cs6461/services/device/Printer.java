package com.gwu.cs6461.services.device;

import com.gwu.cs6461.util.Binary;

import java.util.Observable;

public class Printer extends Observable implements Device {
    private static Printer ourInstance = new Printer();

    public static Printer getInstance() {
        return ourInstance;
    }

    private Printer() {
    }

    @Override
    public void write(Binary inputBuffer) {
        // TODO to be implemented
        setChanged();
        notifyObservers();
    }

    @Override
    public Binary read() {
        return null;
    }
}
