package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.*;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.cpu.registers.Register;
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
        switch (btn.getId()) {
            case "ReadMemButton":
                break;
            case "WriteMemButton":
                break;
            default:
        }
    }

    @FXML
    void handleRegisterButtonClick(MouseEvent mouseEvent) {
        Button btn = (Button) mouseEvent.getSource();
        switch (btn.getId()) {
            case "PCButton":

                break;
            case "MARButton":

                break;
            case "MBRButton":

                break;
            case "R0Button":

                break;
            case "R1Button":

                break;
            case "R2Button":

                break;
            case "R3Button":

                break;
            case "X1Button":

                break;
            case "X2Button":

                break;
            case "X3Button":

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
