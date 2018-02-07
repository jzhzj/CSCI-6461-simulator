package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.MachineImpl;
import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer {

    private MachineImpl machine = MachineImpl.getInstance();


    {
        CPUImpl.getInstance().registers.stream().forEach(register -> {
            Observable observable = (Observable)register;
            observable.addObserver(this);
        });
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
                machine.ipl();
                break;
            case "RUNButton":
                machine.run();
                break;
            case "HALTButton":
                machine.halt();
                promptHalt();
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
        // parse as decimal
        DRAMAddress address = new DRAMAddress().setValue(Integer.parseInt(ramAddressTextField.getText()));
        DRAMData dramData;
        switch (btn.getId()) {
            case "ReadMemButton":
                dramData = DRAMImpl.getInstance().read(address);
                // display as binary
                ramValueTextField.setText(dramData.getBinary());
                break;
            case "WriteMemButton":
                // parse as binary
                dramData = new DRAMDataImpl().setBinaryValue(ramValueTextField.getText());
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
        if(o instanceof IARImpl){
            pcTextField.setText(String.valueOf(IARImpl.getInstance().read().getDecimalValue()));
        } else if (o instanceof MARImpl) {
            marTextField.setText(String.valueOf(MARImpl.getInstance().read().getDecimalValue()));
        } else if(o instanceof MBRImpl) {
            mbrTextField.setText(MBRImpl.getInstance().read().getBinary());
        } else if(o instanceof GPR0Impl){
            r0TextField.setText(GPR0Impl.getInstance().read().getBinary());
        } else if(o instanceof GPR1Impl){
            r1TextField.setText(GPR1Impl.getInstance().read().getBinary());
        } else if(o instanceof GPR2Impl){
            r2TextField.setText(GPR2Impl.getInstance().read().getBinary());
        } else if(o instanceof GPR3Impl){
            r3TextField.setText(GPR3Impl.getInstance().read().getBinary());
        } else if(o instanceof IDXR1Impl){
            x1TextField.setText(String.valueOf(IDXR1Impl.getInstance().read().getDecimalValue()));
        } else if(o instanceof IDXR2Impl){
            x2TextField.setText(String.valueOf(IDXR2Impl.getInstance().read().getDecimalValue()));
        } else if(o instanceof IDXR3Impl){
            x3TextField.setText(String.valueOf(IDXR3Impl.getInstance().read().getDecimalValue()));
        }

    }

    /**
     * Prompt dialog with halt message.
     */
    void promptHalt(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HALT");
        alert.setHeaderText(null);
        alert.setContentText("Machine Halted.");
        alert.showAndWait();
    }
}
