package com.chat.app;

import com.chat.app.service.ChattingBridge;
import com.chat.app.utils.ConfigurationProperties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ClientApplication extends Application {

    private static ChattingBridge chattingBridge;
    @Override
    public void start(Stage stage) throws Exception {

        var loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setMinWidth(800);
        stage.setMinHeight(700);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Chatting-Bridge-App");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws NotBoundException, RemoteException, InterruptedException {
        connectToServer();
        launch();
    }

    private static void connectToServer()  throws RemoteException, NotBoundException, InterruptedException {
        var registry = LocateRegistry.getRegistry(ConfigurationProperties.SERVER_PORT);
        chattingBridge = (ChattingBridge)registry.lookup(ConfigurationProperties.SERVICE_NAME);
        System.out.println("Server Connected Successfully!!!");
    }

    public static ChattingBridge getChattingBridge() {
        return chattingBridge;
    }
}