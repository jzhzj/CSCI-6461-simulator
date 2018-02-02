package com.gwu.cs6461.services.instruction;

import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * super class of all 5
 * Load and Store Instructions
 */
public class LSInstruction implements Instruction {

    private DRAMData data;

    private Register<DRAMData> gpRegister;
    private Register<DRAMAddress> idxRegister;


    public Register<DRAMData> getGpRegister() {
        return gpRegister;
    }

    public void setGpRegister(Register<DRAMData> gpRegister) {
        this.gpRegister = gpRegister;
    }

    public Register<DRAMAddress> getIdxRegister() {
        return idxRegister;
    }

    public void setIdxRegister(Register<DRAMAddress> idxRegister) {
        this.idxRegister = idxRegister;
    }

    public DRAMAddress getEffectiveAddress() {
        return effectiveAddress;
    }

    public void setEffectiveAddress(DRAMAddress effectiveAddress) {
        this.effectiveAddress = effectiveAddress;
    }

    private DRAMAddress effectiveAddress;

    @Override
    public void onFetch() {

    }

    @Override
    public void onDecode() {
        // set target register and effective address
        String instructionBinary = data.getBinary();

        switch (StringUtils.substring(instructionBinary, 6, 7)) {
            case "00":
                gpRegister = GPR0Impl.getInstance();
                break;
            case "01":
                gpRegister = GPR1Impl.getInstance();
                break;
            case "02":
                gpRegister = GPR2Impl.getInstance();
                break;
            case "03":
                gpRegister = GPR3Impl.getInstance();
                break;
            default:
                // TODO throw machine fault

        }

        switch (StringUtils.substring(instructionBinary, 8, 9)) {
            case "00":
                break;
            case "01":
                idxRegister = IDXR1Impl.getInstance();
                break;
            case "02":
                idxRegister = IDXR2Impl.getInstance();
                break;
            case "03":
                idxRegister = IDXR3Impl.getInstance();
                break;
            default:
                // TODO throw machine fault
        }

        effectiveAddress = getEA();
    }

    @Override
    public void onExecute() {

    }

    @Override
    public Instruction fromDRAMData(DRAMData data) {
        this.data = data;
        return this;
    }

    @Override
    public DRAMData toDRAMData() {
        return data;
    }

    private DRAMAddress getEA() {
        String instructionBinary = data.getBinary();
        int addressFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 15));
        DRAMAddress ea = new DRAMAddress();
        switch (StringUtils.substring(instructionBinary, 10, 10)) {
            case "1":
                if(idxRegister == null) {
                    // Address
                    DRAMAddress address = new DRAMAddress().setValue(addressFieldValue);
                    // c(Address)
                    ea.setValue(DRAMImpl.getInstance().read(address).getDecimalValue());
                } else {
                    // c(Xj) + Address
                    DRAMAddress address = new DRAMAddress().setValue(idxRegister.read().getDecimalValue() + addressFieldValue);
                    // c(c(Xj) + Address)
                    ea.setValue(DRAMImpl.getInstance().read(address).getDecimalValue());
                }
                break;
            case "0":
                if(idxRegister == null){
                    // contents of the Address field
                    ea.setValue(addressFieldValue);
                } else {
                    // c(Xj) + contents of the Address field
                    ea.setValue(idxRegister.read().getDecimalValue() + addressFieldValue);
                }
                break;
            default:
                // TODO throw machine fault
        }
        return ea;
    }

}
