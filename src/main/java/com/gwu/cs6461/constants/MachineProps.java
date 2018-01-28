package com.gwu.cs6461.constants;

import java.util.ResourceBundle;

public final class MachineProps {

    static {
        ResourceBundle rb = ResourceBundle.getBundle("machine");
        DATA_PATH_BIT_WIDTH = Integer.parseInt(rb.getString("DATA_PATH_BIT_WIDTH"));
    }


    public static final int DATA_PATH_BIT_WIDTH;
}
