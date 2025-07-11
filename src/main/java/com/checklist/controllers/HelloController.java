package com.checklist.controllers;

import com.checklist.Agenda.Tarefa;
import com.checklist.Agenda.TarefaDAO;
import com.checklist.Database.DataBase;
import com.checklist.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloController {

    private TarefaDAO tarefaDAO;

    private Connection connection;

    public void initialize(Connection conn) {
        // Inicializa o DAO
        connection = conn;
        this.tarefaDAO = new TarefaDAO(connection);
        comboFiltro.getItems().addAll("Todas", "Pendentes", "Concluídas");
        comboFiltro.setValue("Opção de visualização");
        // Carrega as tarefas do banco
        carregarTarefas();
    }

    @FXML
    private Button AdicionarTarefa;
    @FXML
    private VBox listaContainer;
    @FXML
    private ComboBox<String> comboFiltro;

    private List<Tarefa> tarefas = new ArrayList<>();

    @FXML
    private void handleAdicionarTarefa() {
        try {
            // Carrega o FXML da nova janela
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("nova_tarefa.fxml"));
            Parent root = loader.load();

            NovaTarefaController controller = loader.getController();
            controller.setMainController(this); // Passa a referência
            controller.setTarefaDAO(this.tarefaDAO);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void carregarTarefas() {
        // Limpa o container
        listaContainer.getChildren().clear();

        try {
            tarefas = tarefaDAO.listarTarefas();

            // Obtém o filtro selecionado
            String filtro = comboFiltro.getValue();

            // Filtra as tarefas conforme seleção
            List<Tarefa> tarefasFiltradas = tarefas;
            if ("Pendentes".equals(filtro)) {
                tarefasFiltradas = tarefas.stream()
                        .filter(t -> t.getStatus() == 1)
                        .collect(Collectors.toList());
            } else if ("Concluídas".equals(filtro)) {
                tarefasFiltradas = tarefas.stream()
                        .filter(t -> t.getStatus() == 0)
                        .collect(Collectors.toList());
            }

            for (Tarefa tarefa : tarefasFiltradas) {
                // Cria um HBox para cada tarefa
                HBox itemTarefa = new HBox(10);
                itemTarefa.setStyle("-fx-padding: 5; -fx-border-color: #ddd; -fx-border-width: 0 0 1 0;");

                // Label com o texto da tarefa
                Label lblTexto = new Label(tarefa.getDescricao());
                lblTexto.setStyle("-fx-font-size: 14;");
                lblTexto.setPrefWidth(300);

                // Label com o status
                Label lblStatus = new Label(tarefa.getStatus() == 0 ? "Concluída" : "Pendente");
                lblStatus.setStyle(tarefa.getStatus() == 0 ?
                        "-fx-text-fill: green; -fx-font-weight: bold;" :
                        "-fx-text-fill: red; -fx-font-weight: bold;");
                lblStatus.setPrefWidth(100);

                // Label com a data de alteração
                Label lblAlteracao = new Label(tarefa.getDataAlteracao());
                lblAlteracao.setStyle("-fx-font-size: 14;");
                lblAlteracao.setPrefWidth(300);

                // Botão para alterar status
                Button btnAlterar = new Button();
                btnAlterar.setText(tarefa.getStatus() == 0 ? "Marcar Pendente" : "Concluir");
                btnAlterar.setStyle(tarefa.getStatus() == 0 ?
                        "-fx-background-color: #ffcccc;" :
                        "-fx-background-color: #ccffcc;");

                // Ação do botão
                btnAlterar.setOnAction(e -> {
                    try {
                        // Chama o método para atualizar no banco
                        tarefaDAO.alterarStatus(tarefa.getIdTarefa(), tarefa.getStatus());

                        // Atualiza o status localmente
                        int novoStatus = tarefa.getStatus() == 0 ? 1 : 0;
                        tarefa.setStatus(novoStatus);
                        // Atualiza a lista completa após alteração
                        tarefas = tarefaDAO.listarTarefas();
                        // Atualiza a exibição
                        carregarTarefas();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

                // Adiciona os elementos ao HBox
                itemTarefa.getChildren().addAll(lblTexto, lblAlteracao, lblStatus, btnAlterar);

                // Adiciona o HBox ao container principal
                listaContainer.getChildren().add(itemTarefa);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleFiltroChange() {
        carregarTarefas();
    }

    @FXML
    public void atualizarListaTarefas() {
        carregarTarefas();
    }
}