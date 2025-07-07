package project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private Connection conexao;
    private static DataBase INSTANCE = null;
    private DataBase(){
        try{
            conexao = DriverManager.getConnection("jdbc:sqlite:checklist.db");
        } catch (SQLException e){
            System.err.println("Algo deu errado.");
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar no banco", e);
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }

    public void closeConexao(){
        try {
            this.conexao.close();
        } catch (SQLException e) {
            System.err.println("Deu erro ao fechar a conexão !");
            throw new RuntimeException(e);
        }
    }

    public static DataBase getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataBase();
        }
        return INSTANCE;
    }
}
