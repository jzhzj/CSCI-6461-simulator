package com.gwu.cs6461.services.cpu;

/**
 * Singleton
 * CPU
 */
public class CPUImpl implements CPU{

    private static CPUImpl ourInstance = new CPUImpl();

    public static CPUImpl getInstance() {
        return ourInstance;
    }

    private CPUImpl() {

    }

}
