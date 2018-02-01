package com.gwu.cs6461;

import com.gwu.cs6461.services.cpu.registers.MARImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/gwu/cs6461/components/main/main.fxml"));
        primaryStage.setTitle("Simulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        // clear all observers registered on components
        MARImpl.getInstance().deleteObservers();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
