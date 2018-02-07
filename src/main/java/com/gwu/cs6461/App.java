package com.gwu.cs6461;

import com.gwu.cs6461.constants.MachineProps;
import com.gwu.cs6461.services.cpu.CPUImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Observable;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/gwu/cs6461/components/main/main.fxml"));
        primaryStage.setTitle(MachineProps.SIMULATOR_NAME);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // clear all observers registered on components
        CPUImpl.getInstance().getRegisters().stream().forEach(register -> {
            Observable o = (Observable)register;
            o.deleteObservers();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
