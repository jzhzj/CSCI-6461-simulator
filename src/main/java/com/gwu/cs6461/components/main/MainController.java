package com.gwu.cs6461.components.main;

import com.gwu.cs6461.services.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class MainController {

    private MachineImpl machine = MachineImpl.getInstance();

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
        if (machine.isRunning()) {
            machine.powerOff();
            powerButton.setText("Power On");
            powerButton.getStyleClass().remove("button-power-off");
            powerButton.getStyleClass().add("button-power-on");
        } else {
            machine.powerOn();
            powerButton.setText("Power Off");
            powerButton.getStyleClass().remove("button-power-on");
            powerButton.getStyleClass().add("button-power-off");
        }
    }

    @FXML
    protected void handleRunButtonClick(MouseEvent mouseEvent) {

    }

}
