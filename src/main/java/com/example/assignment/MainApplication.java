package com.example.assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("add-lecturer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        // Handle close request at application level
        stage.setOnCloseRequest(event -> {
            event.consume(); // Prevent the default close action
            handleClose(stage); // Show confirmation dialog
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void handleClose(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Any unsaved data will be lost.");

        // Wait for user response
        if (alert.showAndWait().filter(ButtonType.OK::equals).isPresent()) {
            // Close the application
            Platform.exit();
        }
    }
}