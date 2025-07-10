package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NovaTarefaController {
    @FXML
    private TextField txtTarefa;

    @FXML
    private Button btnSalvar;

    @FXML

    private void showMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.showAndWait();
    }
}
