package com.chat.app.controller;


import com.chat.app.ClientApplication;
import com.chat.app.dto.LoginRequestDTO;
import com.chat.app.service.impl.ClientReceiverImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void login(ActionEvent event) throws IOException {

        String email = emailField.getText().trim();
        String password = passwordField.getText();

        if (email.isEmpty()) {
            showError("Email is required.");
            return;
        }

        if (password.isEmpty()) {
            showError("Password is required.");
            return;
        }

        var chattingBridge = ClientApplication.getChattingBridge();
        var loginDetails = new LoginRequestDTO(email, password);
        var response = chattingBridge.login(new ClientReceiverImpl(), loginDetails);


        if(response != null) {

            System.out.println("The response is: " + response);
            var loader = new FXMLLoader(getClass().getResource("/fxml/chat-dashboard.fxml"));
            Parent root = loader.load();
            DashboardController controller = loader.getController();
            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.getScene().setRoot(root);
            controller.init(response);
        }

    }

    @FXML
    private void goToSignup() {
        loadPage("/fxml/signup.fxml");
    }

    private void loadPage(String fxml) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource(fxml));

            Parent root = loader.load();

            Stage stage =
                    (Stage) emailField.getScene().getWindow();

            Scene scene = stage.getScene();

            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
            showError("Unable to load page.");
        }
    }

    private void showError(String message) {
        Alert alert =
                new Alert(Alert.AlertType.ERROR);

        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfo(String message) {
        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
