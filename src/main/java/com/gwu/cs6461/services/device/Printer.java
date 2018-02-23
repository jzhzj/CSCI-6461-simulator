package com.gwu.cs6461.services.device;


import com.gwu.cs6461.services.dram.DRAMData;

import java.util.Observable;

public class Printer extends Observable implements Device<DRAMData> {
    private static Printer ourInstance = new Printer();

    public static Printer getInstance() {
        return ourInstance;
    }

    private Printer() {
    }


    @Override
    public void write(DRAMData inputBuffer) {
        // TODO to be implemented

        setChanged();
        notifyObservers();
    }

    @Override
    public DRAMData read() {
        return null;
    }
}
