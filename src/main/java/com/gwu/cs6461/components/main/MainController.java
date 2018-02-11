package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.MachineImpl;
import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.dram.DRAMAddress;
import com.gwu.cs6461.services.dram.DRAMData;
import com.gwu.cs6461.services.dram.DRAMDataImpl;
import com.gwu.cs6461.services.dram.DRAMImpl;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressBeyondMax;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressToReservedLocations;
import com.gwu.cs6461.services.fault.IllegalOperationCode;
import com.gwu.cs6461.services.fault.MachineFault;
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
        CPUImpl.getInstance().getRegisters().stream().forEach(register -> {
            Observable observable = (Observable)register;
            observable.addObserver(this);
        });
        CPUImpl.getInstance().addObserver(this);
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
        try{
            switch (btn.getId()) {
                case "ILPButton":
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
        } catch (IllegalOperationCode e){
            promptIllegalOpCodeWarning();
        } catch (IllegalMemoryAddressToReservedLocations e){
            promptIllegalWriteReservedMemoryWarning();
        } catch (IllegalMemoryAddressBeyondMax e){
            promptIllegalMemoryAddressBeyondMaxWarning();
        }

    }

    @FXML
    void handleDRAMButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        try{
            DRAMAddress address = new DRAMAddress().setDecimalValue(ramAddressTextField.getText());
            DRAMData dramData;
            switch (btn.getId()) {
                case "ReadMemButton":
                    dramData = DRAMImpl.getInstance().read(address);
                    ramValueTextField.setText(dramData.getBinaryValue());
                    break;
                case "WriteMemButton":
                    dramData = new DRAMDataImpl().setBinaryValue(ramValueTextField.getText());
                    DRAMImpl.getInstance().write(address, dramData);
                    break;
                default:
            }
        } catch (IllegalMemoryAddressToReservedLocations e){
            promptIllegalWriteReservedMemoryWarning();
        } catch (IllegalMemoryAddressBeyondMax e){
            promptIllegalMemoryAddressBeyondMaxWarning();
        } catch (IllegalArgumentException e){
            promptIllegalInputWarning();
        }
    }

    @FXML
    void handleRegisterButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        DRAMAddress address;
        DRAMData dramData;

        try {
            switch (btn.getId()) {
                case "PCButton":
                    address = new DRAMAddress().setDecimalValue(pcTextField.getText());
                    IARImpl.getInstance().write(address);
                    break;
                case "MARButton":
                    address = new DRAMAddress().setDecimalValue(marTextField.getText());
                    MARImpl.getInstance().write(address);
                    break;
                case "MBRButton":
                    dramData = new DRAMDataImpl().setBinaryValue(mbrTextField.getText());
                    MBRImpl.getInstance().write(dramData);
                    break;
                case "R0Button":
                    dramData = new DRAMDataImpl().setBinaryValue(r0TextField.getText());
                    GPR0Impl.getInstance().write(dramData);
                    break;
                case "R1Button":
                    dramData = new DRAMDataImpl().setBinaryValue(r1TextField.getText());
                    GPR1Impl.getInstance().write(dramData);
                    break;
                case "R2Button":
                    dramData = new DRAMDataImpl().setBinaryValue(r2TextField.getText());
                    GPR2Impl.getInstance().write(dramData);
                    break;
                case "R3Button":
                    dramData = new DRAMDataImpl().setBinaryValue(r3TextField.getText());
                    GPR3Impl.getInstance().write(dramData);
                    break;
                case "X1Button":
                    address = new DRAMAddress().setDecimalValue(x1TextField.getText());
                    IDXR1Impl.getInstance().write(address);
                    break;
                case "X2Button":
                    address = new DRAMAddress().setDecimalValue(x2TextField.getText());
                    IDXR2Impl.getInstance().write(address);
                    break;
                case "X3Button":
                    address = new DRAMAddress().setDecimalValue(x3TextField.getText());
                    IDXR3Impl.getInstance().write(address);
                    break;
                default:
            }
        } catch (IllegalArgumentException e){
            promptIllegalInputWarning();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof IARImpl){
            pcTextField.setText(String.valueOf(IARImpl.getInstance().read().getDecimalValue()));
        } else if (o instanceof MARImpl) {
            marTextField.setText(String.valueOf(MARImpl.getInstance().read().getDecimalValue()));
        } else if(o instanceof MBRImpl) {
            mbrTextField.setText(MBRImpl.getInstance().read().getBinaryValue());
        } else if(o instanceof GPR0Impl){
            r0TextField.setText(GPR0Impl.getInstance().read().getBinaryValue());
        } else if(o instanceof GPR1Impl){
            r1TextField.setText(GPR1Impl.getInstance().read().getBinaryValue());
        } else if(o instanceof GPR2Impl){
            r2TextField.setText(GPR2Impl.getInstance().read().getBinaryValue());
        } else if(o instanceof GPR3Impl){
            r3TextField.setText(GPR3Impl.getInstance().read().getBinaryValue());
        } else if(o instanceof IDXR1Impl){
            x1TextField.setText(String.valueOf(IDXR1Impl.getInstance().read().getDecimalValue()));
        } else if(o instanceof IDXR2Impl){
            x2TextField.setText(String.valueOf(IDXR2Impl.getInstance().read().getDecimalValue()));
        } else if(o instanceof IDXR3Impl){
            x3TextField.setText(String.valueOf(IDXR3Impl.getInstance().read().getDecimalValue()));
        } else if(o instanceof MFRImpl){
            MachineFault fault = MFRImpl.getInstance().read();
            if(fault != null){
                mfrTextField.setText(fault.getId().getBinaryValue());
            } else {
                mfrTextField.setText(null);
            }
        } else if(o instanceof CPUImpl){
            promptHalt();
        }

    }

    /**
     * Prompt dialog with halt message.
     */
    void promptHalt(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Halt");
        alert.setHeaderText(null);
        alert.setContentText("Machine Halted.");
        alert.showAndWait();
    }

    /**
     * Show warning when user inputs illegal strings
     */
    void promptIllegalInputWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Input!");
        alert.showAndWait();
    }

    void promptIllegalWriteReservedMemoryWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Machine Fault");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Writing Reserved Memory Location!");
        alert.showAndWait();
    }

    void promptIllegalMemoryAddressBeyondMaxWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Machine Fault");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Memory Address Beyond Max!");
        alert.showAndWait();
    }

    void promptIllegalOpCodeWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Machine Fault");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Op Code!");
        alert.showAndWait();
    }
}
