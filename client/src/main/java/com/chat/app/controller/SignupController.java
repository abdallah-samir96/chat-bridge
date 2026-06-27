package com.chat.app.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SignupController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> genderBox;

    @FXML
    private TextField mobileField;

    @FXML
    private Label avatarLabel;

    private File avatarFile;

    @FXML
    public void initialize() {
        genderBox.setItems(
                FXCollections.observableArrayList(
                        "Male",
                        "Female"
                )
        );
    }

    @FXML
    private void chooseAvatar() {

        FileChooser chooser = new FileChooser();

        chooser.setTitle("Select Profile Picture");

        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Image Files",
                        "*.png",
                        "*.jpg",
                        "*.jpeg"
                )
        );

        avatarFile = chooser.showOpenDialog(
                nameField.getScene().getWindow()
        );

        if (avatarFile != null) {
            avatarLabel.setText(avatarFile.getName());
        }
    }

    @FXML
    private void signup(ActionEvent event) {

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String gender = genderBox.getValue();
        String mobile = mobileField.getText().trim();

        if (name.isEmpty()) {
            showError("Name is required.");
            return;
        }

        if (email.isEmpty()) {
            showError("Email is required.");
            return;
        }

        if (password.isEmpty()) {
            showError("Password is required.");
            return;
        }

        if (gender == null) {
            showError("Please select gender.");
            return;
        }

        if (mobile.isEmpty()) {
            showError("Mobile number is required.");
            return;
        }

        if (avatarFile == null) {
            showError("Please select profile image.");
            return;
        }

        // TODO
        // Save user in database

        System.out.println("Signup");

        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
        System.out.println("Password : " + password);
        System.out.println("Gender : " + gender);
        System.out.println("Mobile : " + mobile);
        System.out.println("Avatar : " + avatarFile.getAbsolutePath());

        showInfo("Account created successfully!");

        clearForm();
        goToLogin();
    }

    @FXML
    private void goToLogin() {
        loadPage("/fxml/login.fxml");
    }

    private void clearForm() {
        nameField.clear();
        emailField.clear();
        passwordField.clear();
        mobileField.clear();
        genderBox.getSelectionModel().clearSelection();
        avatarLabel.setText("No file selected");
        avatarFile = null;
    }

    private void loadPage(String fxml) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource(fxml));

            Parent root = loader.load();

            Stage stage =
                    (Stage) nameField.getScene().getWindow();

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