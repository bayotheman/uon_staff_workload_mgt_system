package com.example.assignment.ui.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    private Stage stage;

    // Called automatically after FXML is loaded
    public void initialize() {
        // This is where you can access the stage and set the close handler
        if (stage != null) {
            setStage(stage);
        }
    }

    public void setStage(Stage stage) {
        stage.setOnCloseRequest(event -> {
            // Consume the event to prevent default close
            event.consume();

            // Show confirmation dialog
            Platform.exit();
        });
    }

    @FXML
    private void handleSignUp() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();

        // Basic validation
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            showAlert("Error", "All fields must be filled out!");
        } else {
            // Add sign-up logic here (e.g., saving to a database)
            showAlert("Success", "Sign-Up successful!\nWelcome, " + firstName + " " + lastName + "!");
        }
    }

    // Helper method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void handleBack(ActionEvent actionEvent) {
        try {
            // Load the Login FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/login.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage for the Login page
            Stage loginStage = new Stage();
            loginStage.setTitle("Login Page");
            loginStage.setScene(new Scene(root, 500, 500));
            loginStage.show();

            // Close the current Sign-Up window
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClose(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Confirmation");
        alert.setHeaderText("Are you sure you want to exit?");
        alert.setContentText("Unsaved data will be lost.");

        // Wait for user response
        if (alert.showAndWait().filter(ButtonType.OK::equals).isPresent()) {
            // Close the application
            handleBack(new ActionEvent(stage, null));
        }
    }
}

