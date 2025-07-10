package controllers;

import com.checklist.checklist.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Button AdicionarTarefa;

    @FXML
    private void handleAdicionarTarefa() {
        try {
            // Carrega o FXML da nova janela
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("nova_tarefa.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            // Define o título e configurações da janela
            stage.setTitle("Adicionar Nova Tarefa");
            stage.setResizable(false);
            // Mostra a janela
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            // Aqui você pode adicionar tratamento de erro
        }
    }
}