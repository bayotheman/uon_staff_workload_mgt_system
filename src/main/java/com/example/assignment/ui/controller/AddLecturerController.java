
package com.example.assignment.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddLecturerController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    @FXML
    private TextField subjectAreaField;

    @FXML
    private TextField managerIdField;

    @FXML
    private ComboBox<String> contractTypeComboBox;

    // Submit the form data
    @FXML
    private void handleSubmit(ActionEvent event) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String id = idField.getText();
        String subjectArea = subjectAreaField.getText();
        String managerId = managerIdField.getText();
        String contractType = contractTypeComboBox.getValue();

        // Basic validation
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || id.isEmpty() || subjectArea.isEmpty() || managerId.isEmpty() || contractType == null) {
            showAlert("Error", "All fields must be filled out!");
        } else {
            // Add Lecturer logic here (e.g., save to database)
            showAlert("Success", "Lecturer Added Successfully!\n" + firstName + " " + lastName);
        }
    }

    // Cancel the form and close the window
    @FXML
    private void handleCancel(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    // Helper method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


