package com.gwu.cs6461.services.cache;

/**
 * Class created to simulate a cache slot
 */

class CacheSlot {
    private String data;
    private int memoryAddress; // It works as a tag

    public CacheSlot(String data, int memoryAddress) {
        super();
        this.data = data;
        this.memoryAddress = memoryAddress;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getMemoryAddress() {
        return memoryAddress;
    }
    public void setMemoryAddress(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }

}
