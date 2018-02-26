package com.gwu.cs6461.services.device;

import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Keyboard extends Observable implements Device<DRAMData, Character> {
    private static Keyboard ourInstance = new Keyboard();

    public static Keyboard getInstance() {
        return ourInstance;
    }

    private Keyboard() {
        executor = Executors.newCachedThreadPool();
    }

    private DRAMData data;
    private ExecutorService executor;

    @Override
    public void write(DRAMData inputBuffer) {

    }

    @Override
    public Future<DRAMData> read() {

        setChanged();
        notifyObservers();
        Callable<DRAMData> task = () -> {
            while(data == null) {

            }
            return data;
        };
        return executor.submit(task);
    }

    @Override
    public void input(Character value) {
        // convert value to DRAMData
        data = new DRAMDataImpl().setDecimalValue((int) value);
    }

    @Override
    public Character output() {
        return null;
    }

    @Override
    public void reset() {
        data = null;
    }
}
