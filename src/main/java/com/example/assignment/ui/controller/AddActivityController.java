package com.example.assignment.ui.controller;

import com.example.assignment.backend.models.Activity;
import com.example.assignment.backend.models.ActivityType;
import com.example.assignment.backend.models.Semester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.util.List;

public class AddActivityController {

    @FXML
    private TextField staffIdField;
    @FXML
    private TextField idField;
    @FXML
    private ComboBox<ActivityType> activityTypeComboBox;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField durationField;
    @FXML
    private ComboBox<Semester> semesterComboBox;
    @FXML
    private TextField instancesField;
    @FXML
    private TextField yearField;

    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    private List<Semester> semesters; // List of available semesters (You can populate this dynamically)

    @FXML
    public void initialize() {
        // Initialize ActivityType ComboBox
        activityTypeComboBox.getItems().setAll(ActivityType.values());

        // Initialize Semester ComboBox
        semesters = List.of(new Semester(), new Semester());  // Example values
        semesterComboBox.getItems().setAll(semesters);
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        // Create a new Activity object
        String staffId = staffIdField.getText();
        String id = idField.getText();
        ActivityType type = activityTypeComboBox.getValue();
        String description = descriptionField.getText();
        int durationInHrs = Integer.parseInt(durationField.getText());
        Semester trimester = semesterComboBox.getValue();
        int instances = Integer.parseInt(instancesField.getText());
        int year = Integer.parseInt(yearField.getText());

        Activity activity = new Activity();

        activity.setId(id);
        activity.setType(type);
        activity.setDescription(description);
        activity.setDurationInHrs(durationInHrs);
        activity.setTrimester(trimester);
        activity.setInstances(instances);
        activity.setYear(year);

        // Handle the activity (save it, etc.)
        System.out.println("Activity Added: " + activity);  // Placeholder for actual logic

        // Close the form
        closeWindow();
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) staffIdField.getScene().getWindow();
        stage.close();
    }
}
