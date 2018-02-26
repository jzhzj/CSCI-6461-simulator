package com.gwu.cs6461.services.sram;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMBlock;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;

import java.util.*;

/**
 * A fully associative, unified cache.
 * Replacing policy: FIFO
 * 16 cache lines
 * 64 words capacity
 */
public class SRAMImpl implements SRAM {

    private static SRAMImpl ourInstance = new SRAMImpl();

    public static SRAMImpl getInstance() {
        return ourInstance;
    }

    private SRAMImpl() {
        blockNumQueue = new ArrayDeque<>(MachineProps.SRAM_BLOCK_SIZE);
        blockMap = new HashMap<>(MachineProps.SRAM_BLOCK_SIZE);
    }

    private Queue<Integer> blockNumQueue;
    private Map<Integer, DRAMBlock> blockMap;

    @Override
    public DRAMData read(DRAMAddress address) {
        int blockNum = address.getBlockNum();
        if(isCached(blockNum)){
            // cache hit
            return blockMap.get(blockNum).read(address.getOffset());
        } else {
            // cache miss
            replace(blockNum);
            return read(address);
        }
    }

    @Override
    public void write(DRAMAddress address, DRAMData data) {
        int blockNum = address.getBlockNum();
        if(isCached(blockNum)){
            // cache hit
            blockMap.get(blockNum).write(address.getOffset(), data);
        } else {
            // cache miss
            replace(blockNum);
            write(address, data);
        }
    }

    @Override
    public DRAMBlock readLowerLevel(int id) {
        return DRAMImpl.getInstance().readBlock(id);
    }

    @Override
    public void writeLowerLevel(int id, DRAMBlock data) {
        DRAMImpl.getInstance().writeBlock(id, data);
    }

    /**
     * Check if the data is cached
     * @param id DRAM block number
     * @return cache hit
     */
    private boolean isCached(int id) {
        return blockMap.containsKey(id);
    }

    /**
     * Replace DRAM block when cache miss
     * policy: FIFO
     */
    private void replace(int id) {
        if(blockMap.size() < MAX_BLOCK_CAPACITY) {
            // compulsory miss, block not yet cached

        } else {
            // cache is at capacity, FIFO
            int outId = blockNumQueue.poll();
            DRAMBlock out = blockMap.remove(outId);
            // write back
            writeLowerLevel(outId, out);
        }
        blockMap.put(id, readLowerLevel(id));
        blockNumQueue.add(id);
    }
}
