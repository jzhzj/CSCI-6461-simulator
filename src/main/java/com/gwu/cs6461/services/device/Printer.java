package com.gwu.cs6461.services.device;

public class Printer implements Device {
    private static Printer ourInstance = new Printer();

    public static Printer getInstance() {
        return ourInstance;
    }

    private Printer() {
    }

    @Override
    public void in() {

    }

    @Override
    public void out() {

    }
}
