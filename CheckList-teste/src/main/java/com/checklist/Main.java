package com.checklist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("hello-view.fxml"));
        primaryStage.setTitle("Gerenciador de Tarefas");
        primaryStage.setScene(new Scene(root, 819, 653));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}