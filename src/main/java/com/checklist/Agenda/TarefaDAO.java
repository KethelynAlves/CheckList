package com.checklist.Agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private Connection conn;
    public TarefaDAO(Connection conn){
        this.conn = conn;
    }

    //Inserção OK
    public void acionarTarefa(String descricao) {
        String sql = "INSERT INTO tarefas(descricao,data_inicio,data_alteracao, status) VALUES (?, strftime('%Y-%m-%d %H:%M:%S', 'now'), strftime('%Y-%m-%d %H:%M:%S', 'now'), 1)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, descricao);
            stmt.executeUpdate();
            System.out.println("Tarefa criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar nova tarefa: " + e.getMessage());
        }
    }

    //Alteração de status OK
    public void alterarStatus(int id, int status) {
        String sql = "UPDATE tarefas SET status = ?, data_alteracao = strftime('%Y-%m-%d %H:%M:%S', 'now') WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, status == 1 ? 0 : 1);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Status atualizados com sucesso.");
        }catch (SQLException e) {
            System.out.println("Erro ao alterar o status da tarefa: " + e.getMessage());
        }
    }

    //Listagem de tarefas OK
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet res = stmt.executeQuery()){
            while (res.next()){
                Tarefa tarefa = new Tarefa(res.getString("descricao"));
                tarefa.setIdTarefa(res.getInt("id"));
                tarefa.setStatus(res.getInt("status"));
                tarefa.setDataInicio(res.getString("data_inicio"));
                tarefa.setDataAlteracao(res.getString("data_alteracao"));
                tarefas.add(tarefa);
            }
        }catch (SQLException e) {
            System.out.println("Erro ao listar as tarefas: " + e.getMessage());
        }
        return tarefas;
    }
}
