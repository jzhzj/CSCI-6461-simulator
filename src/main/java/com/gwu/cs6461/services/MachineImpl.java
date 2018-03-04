package com.gwu.cs6461.services;

import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.device.Device;
import com.gwu.cs6461.services.device.Keyboard;
import com.gwu.cs6461.services.device.Printer;
import com.gwu.cs6461.services.fault.IllegalOperationCode;
import com.gwu.cs6461.services.romloader.RomLoaderImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Singleton
 * Machine
 */
public class MachineImpl implements Machine {

    private static MachineImpl ourInstance = new MachineImpl();

    public static MachineImpl getInstance() {
        return ourInstance;
    }

    private MachineImpl() {
        devices = new HashSet<>();
        devices.add(Printer.getInstance());
        devices.add(Keyboard.getInstance());
    }

    public Set<Device> getDevices() {
        return devices;
    }

    private Set<Device> devices;

    @Override
    public void run() throws IllegalOperationCode {
        CPUImpl.getInstance().resume();
    }

    @Override
    public void halt() {
        CPUImpl.getInstance().pause();
    }

    @Override
    public void singleStep() throws IllegalOperationCode {
        CPUImpl.getInstance().pauseAfter(1);
    }

    @Override
    public void ipl() {
        // reset CPU and SRAM, reload DRAM
        CPUImpl.getInstance().reset();
        RomLoaderImpl.getInstance().boot();
    }
}
