package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.*;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer {

    private MachineImpl machine = MachineImpl.getInstance();


    {
        MARImpl.getInstance().addObserver(this);
    }

    @FXML
    private TextField pcTextField;
    @FXML
    private TextField marTextField;
    @FXML
    private TextField mbrTextField;
    @FXML
    private TextField ccTextField;
    @FXML
    private TextField mfrTextField;
    @FXML
    private TextField r0TextField;
    @FXML
    private TextField r1TextField;
    @FXML
    private TextField r2TextField;
    @FXML
    private TextField r3TextField;
    @FXML
    private TextField x1TextField;
    @FXML
    private TextField x2TextField;
    @FXML
    private TextField x3TextField;
    @FXML
    private TextField ramAddressTextField;
    @FXML
    private TextField ramValueTextField;


    @FXML
    void handleDebugButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        switch (btn.getId()) {
            case "ILPButton":
                MARImpl.getInstance().reset();
                machine.ipl();
                break;
            case "RUNButton":
                machine.run();
                break;
            case "HALTButton":
                machine.halt();
                break;
            case "SSButton":
                machine.singleStep();
                break;
            default:
        }

    }

    @FXML
    void handleDRAMButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        DRAMAddress address = new DRAMAddress().setValue(Integer.parseInt(ramAddressTextField.getText()));
        DRAMData dramData;
        switch (btn.getId()) {
            case "ReadMemButton":
                dramData = DRAMImpl.getInstance().read(address);
                ramValueTextField.setText(dramData.getBinary());
                break;
            case "WriteMemButton":
                dramData = new DRAMDataImpl().setValue(Integer.parseInt(ramValueTextField.getText()));
                DRAMImpl.getInstance().write(address, dramData);
                break;
            default:
        }
    }

    @FXML
    void handleRegisterButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        DRAMAddress address;
        DRAMData dramData;

        switch (btn.getId()) {
            case "PCButton":
                address = new DRAMAddress().setValue(Integer.parseInt(pcTextField.getText()));
                IARImpl.getInstance().write(address);
                break;
            case "MARButton":
                address = new DRAMAddress().setValue(Integer.parseInt(marTextField.getText()));
                MARImpl.getInstance().write(address);
                break;
            case "MBRButton":
                dramData = new DRAMDataImpl().setValue(Integer.parseInt(mbrTextField.getText()));
                MBRImpl.getInstance().write(dramData);
                break;
            case "R0Button":
                dramData = new DRAMDataImpl().setValue(Integer.parseInt(r0TextField.getText()));
                GPR0Impl.getInstance().write(dramData);
                break;
            case "R1Button":
                dramData = new DRAMDataImpl().setValue(Integer.parseInt(r1TextField.getText()));
                GPR1Impl.getInstance().write(dramData);
                break;
            case "R2Button":
                dramData = new DRAMDataImpl().setValue(Integer.parseInt(r2TextField.getText()));
                GPR2Impl.getInstance().write(dramData);
                break;
            case "R3Button":
                dramData = new DRAMDataImpl().setValue(Integer.parseInt(r3TextField.getText()));
                GPR3Impl.getInstance().write(dramData);
                break;
            case "X1Button":
                address = new DRAMAddress().setValue(Integer.parseInt(x1TextField.getText()));
                IDXR1Impl.getInstance().write(address);
                break;
            case "X2Button":
                address = new DRAMAddress().setValue(Integer.parseInt(x2TextField.getText()));
                IDXR2Impl.getInstance().write(address);
                break;
            case "X3Button":
                address = new DRAMAddress().setValue(Integer.parseInt(x3TextField.getText()));
                IDXR3Impl.getInstance().write(address);
                break;
            default:
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof MARImpl) {
            System.out.println("o = [" + o + "], arg = [" + arg + "]");
        } else {
            System.out.println("not");
        }

    }
}
