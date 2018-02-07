package com.gwu.cs6461.services.instruction;

import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * 2nd tier implementation of Instruction
 * super class of all 5
 * Load and Store Instructions
 */
public class LSInstructionImpl extends InstructionImpl {

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
    public Runnable onDecode() {

        Runnable decodeTask = () -> {
            // set target register and effective address
            String instructionBinary = toDRAMData().getBinaryValue();

            switch (StringUtils.substring(instructionBinary, 6, 8)) {
                case "00":
                    // 00
                    gpRegister = GPR0Impl.getInstance();
                    break;
                case "01":
                    // 01
                    gpRegister = GPR1Impl.getInstance();
                    break;
                case "10":
                    // 02
                    gpRegister = GPR2Impl.getInstance();
                    break;
                case "11":
                    // 03
                    gpRegister = GPR3Impl.getInstance();
                    break;
                default:
                    // TODO throw machine fault

            }

            switch (StringUtils.substring(instructionBinary, 8, 10)) {
                case "00":
                    // 00
                    break;
                case "01":
                    // 01
                    idxRegister = IDXR1Impl.getInstance();
                    break;
                case "10":
                    // 02
                    idxRegister = IDXR2Impl.getInstance();
                    break;
                case "11":
                    // 03
                    idxRegister = IDXR3Impl.getInstance();
                    break;
                default:
                    // TODO throw machine fault
            }

            effectiveAddress = getEA();
        };

        return decodeTask;

    }




    private DRAMAddress getEA() {
        String instructionBinary = toDRAMData().getBinaryValue();
        int addressFieldValue = Integer.parseInt(StringUtils.substring(instructionBinary, 11, 16), 2);
        DRAMAddress ea = new DRAMAddress();
        switch (StringUtils.substring(instructionBinary, 10, 11)) {
            case "1":
                if(idxRegister == null) {
                    // Address
                    DRAMAddress address = new DRAMAddress().setDecimalValue(addressFieldValue);
                    // c(Address)
                    ea.setDecimalValue(DRAMImpl.getInstance().read(address).getDecimalValue());
                } else {
                    // c(Xj) + Address
                    DRAMAddress address = new DRAMAddress().setDecimalValue(idxRegister.read().getDecimalValue() + addressFieldValue);
                    // c(c(Xj) + Address)
                    ea.setDecimalValue(DRAMImpl.getInstance().read(address).getDecimalValue());
                }
                break;
            case "0":
                if(idxRegister == null){
                    // contents of the Address field
                    ea.setDecimalValue(addressFieldValue);
                } else {
                    // c(Xj) + contents of the Address field
                    ea.setDecimalValue(idxRegister.read().getDecimalValue() + addressFieldValue);
                }
                break;
            default:
                // TODO throw machine fault
        }
        return ea;
    }

}
