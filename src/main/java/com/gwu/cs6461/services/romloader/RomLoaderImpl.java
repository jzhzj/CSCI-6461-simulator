package com.gwu.cs6461.services.romloader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cpu.registers.IARImpl;
import com.gwu.cs6461.services.dram.DRAMAddressImpl;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.sram.SRAMImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Singleton
 * Rom Loader
 */
public class RomLoaderImpl implements RomLoader {

    private static RomLoaderImpl ourInstance = new RomLoaderImpl();

    public static RomLoaderImpl getInstance() {
        return ourInstance;
    }

    private RomLoaderImpl() {

    }

    @Override
    public void boot() {
        DRAMImpl.getInstance().reset();
        SRAMImpl.getInstance().reset();

        // set PC to the 1st instruction to be executed
        IARImpl.getInstance().reset();


        Type listType = new TypeToken<LinkedList<RomData>>() {
        }.getType();
        Gson gson = new Gson();
        BufferedReader bufferedReader = loadFile();
        List<RomData> romDataList = gson.fromJson(bufferedReader, listType);

        // load some customized instructions into memory (8) here, romDataList
        for (int i = 0, length = romDataList.size(); i < length; i++) {
            DRAMImpl.getInstance().write(
                    new DRAMAddressImpl().setDecimalValue(MachineProps.INSTRUCTION_START_ADDRESS +13+i),
                    new DRAMDataImpl().setBinaryValue(romDataList.get(i).getValue()));
        }

        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ok, loader's job is done.
    }

    private BufferedReader loadFile() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(BOOT_FILE_PATH)));
        return bufferedReader;
    }
}
