package com.checklist.controllers;

import com.checklist.Agenda.TarefaDAO;
import com.checklist.Database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;

public class NovaTarefaController {

    @FXML
    private TextField txtTarefa;

    @FXML
    private Button btnSalvar;

    Connection connection = DataBase.getInstance().getConexao();
    TarefaDAO tarefaDAO = new TarefaDAO(connection);

    private HelloController mainController;

    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleSalvar() {
        String tarefa = txtTarefa.getText().trim();

        if (!tarefa.isEmpty()) {
            tarefaDAO.acionarTarefa(tarefa);
            System.out.println("Tarefa salva: " + tarefa);
            showMessage("Tarefa cadastrada com sucesso!");
            mainController.atualizarListaTarefas();
            Stage stage = (Stage) btnSalvar.getScene().getWindow();
            stage.close();
        } else {
            showMessage("Escreva uma tarefa.");
        }
    }

    private void showMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.NONE, msg, ButtonType.OK);
        alert.setTitle("Erro ao adicionar nova tarefa");
        alert.showAndWait();
    }
}
