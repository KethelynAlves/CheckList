package com.checklist;

import com.checklist.Agenda.TarefaDAO;
import com.checklist.Database.BDconnection;
import com.checklist.Database.DataBase;
import com.checklist.controllers.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        BDconnection.start();
        Connection conn = DataBase.getInstance().getConexao();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        HelloController helloController = fxmlLoader.getController();
        helloController.initialize(conn);
        primaryStage.setTitle("Gerenciador de Tarefas");
        primaryStage.setScene(new Scene(root, 900, 653));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}