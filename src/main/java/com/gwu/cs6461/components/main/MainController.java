package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.MachineImpl;
import com.gwu.cs6461.services.cpu.CPUImpl;
import com.gwu.cs6461.services.cpu.registers.*;
import com.gwu.cs6461.services.device.Keyboard;
import com.gwu.cs6461.services.device.Printer;
import com.gwu.cs6461.services.dram.*;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressBeyondMax;
import com.gwu.cs6461.services.fault.IllegalMemoryAddressToReservedLocations;
import com.gwu.cs6461.services.fault.IllegalOperationCode;
import com.gwu.cs6461.services.fault.MachineFault;
import com.gwu.cs6461.services.sram.SRAMImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.apache.commons.lang3.StringUtils;

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class MainController implements Observer {

    private MachineImpl machine = MachineImpl.getInstance();


    {
        CPUImpl.getInstance().getRegisters().forEach(register -> {
            Observable observable = (Observable)register;
            observable.addObserver(this);
        });

        CPUImpl.getInstance().addObserver(this);

        MachineImpl.getInstance().getDevices().forEach(device -> {
            Observable observable = (Observable) device;
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
    private TextField irTextField;
    @FXML
    private TextField ccTextField;
    @FXML
    private TextField mfrTextField;
    @FXML
    private TextField msrTextField;
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
    private TextField cacheAddressTextField;
    @FXML
    private TextField cacheValueTextField;
    @FXML
    private TextArea printerTextArea;


    @FXML
    void handleDebugButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        try{
            switch (btn.getId()) {
                case "ILPButton":
                    machine.ipl();
                    printerTextArea.setText(null);
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
            e.printStackTrace();
            promptIllegalMemoryAddressBeyondMaxWarning();
        }

    }

    @FXML
    void handleDRAMButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        try{
            DRAMAddress address = new DRAMAddressImpl().setDecimalValue(ramAddressTextField.getText());
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
    void handleSRAMButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        try{
            DRAMAddress address = new DRAMAddressImpl().setDecimalValue(cacheAddressTextField.getText());
            DRAMData dramData;
            switch (btn.getId()) {
                case "ReadCacheButton":
                    dramData = SRAMImpl.getInstance().read(address);
                    cacheValueTextField.setText(dramData.getBinaryValue());
                    break;
                case "WriteCacheButton":
                    dramData = new DRAMDataImpl().setBinaryValue(cacheValueTextField.getText());
                    SRAMImpl.getInstance().write(address, dramData);
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
                    address = new DRAMAddressImpl().setDecimalValue(pcTextField.getText());
                    IARImpl.getInstance().write(address);
                    break;
                case "MARButton":
                    address = new DRAMAddressImpl().setDecimalValue(marTextField.getText());
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
                    address = new DRAMAddressImpl().setDecimalValue(x1TextField.getText());
                    IDXR1Impl.getInstance().write(address);
                    break;
                case "X2Button":
                    address = new DRAMAddressImpl().setDecimalValue(x2TextField.getText());
                    IDXR2Impl.getInstance().write(address);
                    break;
                case "X3Button":
                    address = new DRAMAddressImpl().setDecimalValue(x3TextField.getText());
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
        } else if(o instanceof IRImpl){
            irTextField.setText(IRImpl.getInstance().read().getBinaryValue());
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
        } else if(o instanceof MSRImpl){
            msrTextField.setText(MSRImpl.getInstance().read().toString());
        } else if(o instanceof CCRImpl){
            ccTextField.setText(CCRImpl.getInstance().read().toString());
        } else if(o instanceof Printer) {
            printerTextArea.setText(StringUtils.join(printerTextArea.getText(), String.valueOf(Printer.getInstance().output())));
        } else if(o instanceof Keyboard) {
            promptRequireInput();
        }

    }

    /**
     * Prompt dialog with halt message.
     */
    private void promptHalt(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Halt");
        alert.setHeaderText(null);
        alert.setContentText("Machine Halted.");
        alert.showAndWait();
    }

    /**
     * Show warning when user inputs illegal strings
     */
    private void promptIllegalInputWarning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Input!");
        alert.showAndWait();
    }

    private void promptIllegalWriteReservedMemoryWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Machine Fault");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Writing Reserved Memory Location!");
        alert.showAndWait();
    }

    private void promptIllegalMemoryAddressBeyondMaxWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Machine Fault");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Memory Address Beyond Max!");
        alert.showAndWait();
    }

    private void promptIllegalOpCodeWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Machine Fault");
        alert.setHeaderText(null);
        alert.setContentText("Illegal Op Code!");
        alert.showAndWait();
    }

    private void promptRequireInput() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Instruction Requires Input");
        dialog.setHeaderText(null);
        dialog.setContentText("Please Enter A Char:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(userInput ->  {
            if(StringUtils.isEmpty(userInput)){
                // as Enter / return button
                Keyboard.getInstance().input((char)13);
            } else {
                Keyboard.getInstance().input(userInput.toCharArray()[0]);
                printerTextArea.setText(StringUtils.join(printerTextArea.getText(), String.valueOf(userInput)));
            }
        });
    }
}
