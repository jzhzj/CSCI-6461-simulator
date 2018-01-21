package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    public static boolean running = false;
    private ALU alu;
    private Memory memory;
    private List<Register> regular_regs = new ArrayList<>(4);
    private List<Register> index_regs = new ArrayList<>(3);

    @FXML
    private Button powerButton;

    @FXML
    private ListView<String> memoryListView;

    @FXML
    protected void handleIPLButtonClick(MouseEvent mouseEvent) {

    }

    @FXML
    protected void handleSingleStepButtonClick(MouseEvent mouseEvent) {

    }

    @FXML
    protected void handlePowerButtonClick(MouseEvent mouseEvent) {
        if (running) {
            powerOff();
            powerButton.setText("Power On");
            powerButton.getStyleClass().remove("button-power-off");
            powerButton.getStyleClass().add("button-power-on");
        } else {
            powerOn();
            powerButton.setText("Power Off");
            powerButton.getStyleClass().remove("button-power-on");
            powerButton.getStyleClass().add("button-power-off");
        }
        running = !running;
    }


    private void powerOn() {
        alu = new ALUImpl();
        memory = new MemoryImpl();
        regular_regs.forEach(register -> new RegisterImpl());
        index_regs.forEach(register -> new RegisterImpl());
    }

    private void powerOff() {
        alu = null;
        memory = null;
        regular_regs.clear();
        index_regs.clear();
    }
}
