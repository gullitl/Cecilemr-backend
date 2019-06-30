package com.cecilemrbackend;

import com.cecilemrbackend.controller.MonitorController;
import com.cecilemrbackend.enumeration.NominatimCountryCodes;
import com.cecilemrbackend.util.CentralizeLocationRelativeToScreen;
import com.cecilemrbackend.util.I18nFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {

    @Override
    public void start(Stage monitorStage) throws Exception{
        try {
            NominatimCountryCodes nominatimCountryCodes = new ObjectMapper()
                    .readValue(new File("include/nominatim.i18n"), NominatimCountryCodes.class);
            I18nFactory.getInstance().setSystemLanguage(nominatimCountryCodes);
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

        }

        FXMLLoader loader = new FXMLLoader();
        loader.setResources(I18nFactory.getInstance().getResourceBundle());
        loader.setLocation(getClass().getResource("/fxml/Monitor.fxml"));
        StackPane root = loader.load();
        Scene scene = new Scene(root);
        monitorStage.setScene(scene);
        monitorStage.setTitle(I18nFactory.getInstance().getResourceBundle().getString("stage.title"));
        monitorStage.setX(CentralizeLocationRelativeToScreen.getX(root.getPrefWidth()));
        monitorStage.setY(CentralizeLocationRelativeToScreen.getY(root.getPrefHeight()));
        monitorStage.setResizable(false);
        monitorStage.setMaximized(false);

        MonitorController controller = loader.getController();
        controller.setMonitorStage(monitorStage);

        monitorStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
