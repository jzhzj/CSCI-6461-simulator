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
    void handleIPLButtonClick(MouseEvent mouseEvent) {

    }

    @FXML
    void handleSingleStepButtonClick(MouseEvent mouseEvent) {

    }

    @FXML
    void handleRunButtonClick(MouseEvent mouseEvent) {

    }

    @FXML
    void handleHaltButtonClick(MouseEvent mouseEvent) {

    }
}
