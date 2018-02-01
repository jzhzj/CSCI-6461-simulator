package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.*;
import com.gwu.cs6461.services.cpu.registers.MARImpl;
import com.gwu.cs6461.services.cpu.registers.Register;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer{

    private MachineImpl machine = MachineImpl.getInstance();


    {
        MARImpl.getInstance().addObserver(this);
    }

    @FXML
    private Button powerButton;

    @FXML
    private ListView<String> memoryListView;

    @FXML
    void handleIPLButtonClick(MouseEvent mouseEvent) {
        MARImpl.getInstance().reset();
        machine.ipl();
    }

    @FXML
    void handleSingleStepButtonClick(MouseEvent mouseEvent) {
        machine.singleStep();
    }

    @FXML
    void handleRunButtonClick(MouseEvent mouseEvent) {
        machine.run();
    }

    @FXML
    void handleHaltButtonClick(MouseEvent mouseEvent) {
        machine.halt();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof MARImpl){
            System.out.println("o = [" + o + "], arg = [" + arg + "]");
        } else {
            System.out.println("not");
        }

    }
}
