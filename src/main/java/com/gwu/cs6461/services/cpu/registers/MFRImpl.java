package com.gwu.cs6461.services.cpu.registers;

import com.gwu.cs6461.services.fault.MachineFault;

import java.util.Observable;

/**
 * Singleton
 * Machine Fault Register: contains the ID code if a machine fault after it occurs
 * 4 bits
 */
public class MFRImpl extends Observable implements Register<MachineFault> {

    private MachineFault machineFault;

    private static MFRImpl ourInstance = new MFRImpl();

    public static MFRImpl getInstance() {
        return ourInstance;
    }

    private MFRImpl() {

    }

    @Override
    public void write(MachineFault data) {
        machineFault = data;
        setChanged();
        notifyObservers();
    }

    @Override
    public MachineFault read() {
        return machineFault;
    }

    @Override
    public void reset() {
        write(null);
    }
}
