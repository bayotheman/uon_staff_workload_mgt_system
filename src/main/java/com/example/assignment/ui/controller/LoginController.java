package com.example.assignment.ui.controller;

import com.example.assignment.backend.services.AuthenticationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    private final AuthenticationService service = AuthenticationService.getInstance();

    @FXML
    private void handleLogin(ActionEvent actionEvent) {

    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void handleSignUp(ActionEvent actionEvent) {
        try {
            // Load the Sign-Up FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/signup.fxml"));

            Parent root = fxmlLoader.load();

            // Create a new stage for the Sign-Up page
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Sign-Up Page");
            signUpStage.setScene(new Scene(root, 400, 300));
            signUpStage.show();

            //close current window
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
