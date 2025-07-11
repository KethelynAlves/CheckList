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

    public void acionarTarefa(String descricao) throws SQLException {
        String sql = "INSERT INTO tarefa(descricao,data_inicio,concluido) VALUES (?, strftime('%d-%m-%y %H-%M', 'now'), 0)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, descricao);
            stmt.executeUpdate();
        }
    }
    public void alterarStatus(int idTarefa, boolean status) throws SQLException{
        String sql = "UPDATE tarefa SET concluido = ?, data_alteracao = datetime('now') WHERE idTarefa=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, status?1:0);
            stmt.setInt(2, idTarefa);
            stmt.executeUpdate();
        }
    }
    public List<Tarefa> listarTarefas(String casos) throws SQLException{
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = switch (casos.toLowerCase()){
            case "pendentes" -> "SELECT * FROM tarefa WHERE concluido = 1";
            default -> "SELECT * FROM tarefa";
        };
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet res = stmt.executeQuery()){
            while (res.next()){
                Tarefa tarefa = new Tarefa(
                        res.getInt("idTarefa"),
                        res.getString("descricao"),
                        res.getInt("concluido") == 1,
                        res.getString("data_inicio"),
                        res.getString("data_alteracao")
                );
                tarefas.add(tarefa);
            }
        }
        return tarefas;
    }
}
