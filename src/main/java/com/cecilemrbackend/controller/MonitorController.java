package com.cecilemrbackend.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class MonitorController {
    @Setter
    private Stage monitorStage;
    @Setter
    @FXML
    private Label lblVersion;
    private static MonitorController uniqueInstance;

    public static synchronized MonitorController getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MonitorController();
        }
        return uniqueInstance;
    }

    @FXML
    private void jbtnCloseAction() {
        monitorStage.close();
    }

}
