package com.gwu.cs6461.services.device;

public class Keyboard implements Device {
    private static Keyboard ourInstance = new Keyboard();

    public static Keyboard getInstance() {
        return ourInstance;
    }

    private Keyboard() {
    }

    @Override
    public void in() {

    }

    @Override
    public void out() {

    }
}
