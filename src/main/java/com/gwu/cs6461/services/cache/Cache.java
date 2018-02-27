package com.gwu.cs6461.services.cache;

import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;

import java.util.ArrayList;

/**
 * Class created to simulate a cache slot
 */


/**
 * Class created to manage instructions regarding cache
 */
public class Cache {

    //Only can be one instance of cache in the application
    private static Cache instance = null;
    //Cache slots, representing the size and data into the cache
    private ArrayList<CacheSlot> cacheSlots;
    //Size of the cache
    private int cacheSize;
    //Flag to handle FIFO
    private int addCounter;

    private static int MEMORY_SIZE = 2048;

    /**
     *
     * @param size - Normally 2048 - To make a fully associative cache
     * 				 with same size than memory in this case.
     */
    private Cache(int size) {

        cacheSize = size;
        cacheSlots = new ArrayList<>();
        for(int i = 0; i < size; i ++){
            cacheSlots.add(null);
        }
        this.addCounter = 0;
    }

    /**
     * Singleton call for cache
     * @return the cache
     */
    public static Cache getInstance() {
        if(instance == null) {
            instance = new Cache(MEMORY_SIZE);
        }
        return instance;
    }

    /**
     * Check if cache has in the memory address what the machine needs
     * @param memoryAddress in decimal
     * @return data from memory address after fetching it from cache
     * 		   or adding it to the cache if it wasn't stored it.
     */
    public String checkCache(DRAMAddress memoryAddress) throws Exception{
        CacheSlot slot = find(memoryAddress.getDecimalValue());
        if(memoryAddress.getDecimalValue() > 5){
            if(slot == null){
                return bringMemoryAddressToCache(memoryAddress);
            }
            return slot.getData();
        }
        throw new Exception("Reserverd Memory");
    }

    /**
     * Write data to cache
     * @param memoryAddress
     * @param newData
     */
    public void updateData(DRAMAddress memoryAddress, String newData){
        CacheSlot slot = find(memoryAddress.getDecimalValue());
        if(memoryAddress.getDecimalValue() > 5) {
            //Verify first if the the memory address to be updated is in the cache or not
            if (slot != null) {
                writeThrough(memoryAddress, slot, newData);
            } else {
                bringMemoryAddressToCache(memoryAddress);
                slot = find(memoryAddress.getDecimalValue());
                writeThrough(memoryAddress, slot, newData);
            }
        }
    }

    /**
     * Reset all cache allocated
     */
    public void resetCache(){
        System.out.println("Resetting Cache...");
        instance = new Cache(MEMORY_SIZE);
        System.out.println("Cache Reset...");
    }

    /**
     * Find if a memory address is in cache
     * @param memoryAddress
     * @return cache slot if it's found or null if it's not
     */
    private CacheSlot find(int memoryAddress) {
        for(int i = 0; i < cacheSize; i++){
            if(cacheSlots.get(i) != null && cacheSlots.get(i).getMemoryAddress() == memoryAddress){
                System.out.println("Memory address " + memoryAddress + " found in Cache...");
                return cacheSlots.get(i);
            }
        }
        System.out.println("Memory address " + memoryAddress + " is NOT in Cache...");
        return null;
    }

    /**
     * Find if a memory address is in cache
     * @param memoryAddress
     * @return cache position where is found
     */
    private Integer findPosition(int memoryAddress) {
        for(int i = 0; i < cacheSize; i++){
            if(cacheSlots.get(i) != null && cacheSlots.get(i).getMemoryAddress() == memoryAddress){
                return i;
            }
        }
        return null;
    }

    /**
     * Put memory information in cache
     * @param memoryAddress
     */
    private String bringMemoryAddressToCache(DRAMAddress memoryAddress){
        String data = DRAMImpl.getInstance().read(memoryAddress).getBinaryValue();
        CacheSlot slot = new CacheSlot(data, memoryAddress.getDecimalValue());
        if(cacheSize == MEMORY_SIZE){
            System.out.println("Bringing data from memory position " + memoryAddress.getDecimalValue() + " to cache position " + memoryAddress.getDecimalValue());
            cacheSlots.set(memoryAddress.getDecimalValue(), slot);
            return data;
        } else {
            cacheSlots.set(addCounter, slot);
            System.out.println("Bringing data from memory address position " + memoryAddress.getDecimalValue() + " to position " + addCounter);
            incrementAddCounter();
            return data;
        }
    }

    /**
     * Write to memory (after write to cache)
     * @param memoryAddress
     * @param slot
     * @param data
     */
    private void writeThrough(DRAMAddress memoryAddress, CacheSlot slot, String data){
        System.out.println("Writing data to cache position " + findPosition(memoryAddress.getDecimalValue()));
        slot.setData(data);
        System.out.println("Writing data to memory address position " + memoryAddress.getDecimalValue());
        DRAMImpl.getInstance().write(memoryAddress, new DRAMDataImpl().setBinaryValue(slot.getData()));
    }

    /**
     * Increment or initialize flag for FIFO handling in the cache
     */
    private void incrementAddCounter(){
        //Verify first if cache is full
        if(addCounter == cacheSize - 1){
            addCounter = 0;
        } else {
            addCounter++;
        }
    }

}
