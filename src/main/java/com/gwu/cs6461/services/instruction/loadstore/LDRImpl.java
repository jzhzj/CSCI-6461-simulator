package com.gwu.cs6461.services.instruction.loadstore;

import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * LDR Instruction
 * Load Register From Memory, r = 0..3
 */
public class LDRImpl extends LSImpl {

    @Override
    public Runnable onExecute() {
        Runnable executeTask = () -> {
            // c(EA)
            DRAMData dataCEA = DRAMImpl.getInstance().read(getEffectiveAddress());

            switch (StringUtils.substring(toDRAMData().getBinaryValue(), 10, 11)) {
                case "1":
                    // r <- c(c(EA))
                    // c(c(EA))
                    DRAMData dataCCEA = DRAMImpl.getInstance().read(new DRAMAddress().setDecimalValue(dataCEA.getDecimalValue()));
                    getGpRegister().write(dataCCEA);
                    break;
                case "0":
                    // r <− c(EA)
                    getGpRegister().write(dataCEA);
                    break;
                default:
                    // TODO throw machine fault
            }
        };
        return executeTask;
    }
}
