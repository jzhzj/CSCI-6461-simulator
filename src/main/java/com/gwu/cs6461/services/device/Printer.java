package com.gwu.cs6461.services.device;


import com.gwu.cs6461.services.dram.DRAMData;

import java.util.Observable;
import java.util.concurrent.Future;

public class Printer extends Observable implements Device<DRAMData, Character> {
    private static Printer ourInstance = new Printer();

    public static Printer getInstance() {
        return ourInstance;
    }

    private Printer() {
    }


    private DRAMData data;

    @Override
    public void write(DRAMData inputBuffer) {
        data = inputBuffer;
        setChanged();
        notifyObservers();
    }

    @Override
    public Future<DRAMData> read() {
        return null;
    }

    @Override
    public void input(Character value) {

    }

    @Override
    public Character output() {
        // convert data to char
        return (char) data.getDecimalValue();
    }

    @Override
    public void reset() {
        data = null;
    }
}
