package com.chat.app.controller;

import com.chat.app.ClientApplication;
import com.chat.app.dto.LoginResponseDTO;
import com.chat.app.dto.MessageDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

public class DashboardController {

    @FXML
    private Label loggedUserLabel;

    @FXML
    private Label selectedUserLabel;

    @FXML
    private ListView<String> usersListView;

    @FXML
    private ListView<String> messagesListView;

    @FXML
    private TextField messageField;

    private LoginResponseDTO loggedUser;

    private String selectedUser;

    public void init(LoginResponseDTO response) {
        var users = List.of("Ahmed", "Mohamed", "Adel", "Ibraheem");
        usersListView.getItems().addAll(users);
        this.loggedUser = response;
        loggedUserLabel.setText(response.name());

        usersListView.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldUser, newUser) -> {

                            selectedUser = newUser;

                            if (newUser != null) {
                                selectedUserLabel.setText(
                                        "Chat with "
                                                + newUser);
                            }
                        });
    }

    @FXML
    private void sendMessage() {

        if (selectedUser == null) {
            return;
        }

        String text = messageField.getText();

        if (text.isBlank()) {
            return;
        }

        var message =
                new MessageDTO(
                        loggedUser.email(),
                        selectedUser,
                        text,
                        LocalDateTime.now()
                );

        try {
            ClientApplication
                    .getChattingBridge()
                    .send(message);

            messagesListView
                    .getItems()
                    .add("Me: " + text);

            messageField.clear();

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        System.out.println("Logout Page" + event);
        loadPage("/fxml/login.fxml");
    }


    private void loadPage(String fxml) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource(fxml));

            Parent root = loader.load();
            var stage = (Stage) selectedUserLabel.getScene().getWindow();
            Scene scene = stage.getScene();

            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}