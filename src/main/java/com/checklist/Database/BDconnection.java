package com.checklist.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDconnection {
    public static void start(){
        Connection conn = DataBase.getInstance().getConexao();
        try{
            Statement statement = conn.createStatement();
            String sql = FilesUtil.loadTextFile("com/checklist/tabelaLista.sql");
            statement.execute(sql);

            ResultSet res = statement.executeQuery("SELECT * FROM tarefas");
            while (res.next()){
                System.out.println("Tarefa: "+res.getString("descricao"));
            }
        } catch (SQLException | IOException e) {
            System.out.println("Erro ao iniciar banco de dados:");
            e.printStackTrace();
        }
    }
}
