package com.checklist.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private Connection conexao;
    private static DataBase INSTANCE = null;
    private static final String URL = "jdbc:sqlite:checklist.db";

    private DataBase(){
        try{
            conexao = DriverManager.getConnection(URL);
        } catch (SQLException e){
            System.err.println("Erro ao conectar no banco");
            e.printStackTrace();
            conexao=null;
        }
    }

    public Connection getConexao() {
        if (conexao == null) {
            try {
                this.conexao = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                System.err.println("Erro ao restaurar conexão:");
                e.printStackTrace();
            }
        }
        return conexao;
    }

    public void closeConexao(){
        try {
            this.conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão.");
            e.printStackTrace();
        }
    }

    public static DataBase getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataBase();
        }
        return INSTANCE;
    }
}
