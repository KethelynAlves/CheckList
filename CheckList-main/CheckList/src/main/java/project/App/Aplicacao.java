package project.App;

import project.Agenda.TarefaDAO;

import java.sql.Connection;
import java.util.Scanner;

public class Aplicacao {
    private final TarefaDAO dao;
    private final Scanner scanner;

    public Aplicacao(Connection conn){
        this.dao = new TarefaDAO(conn);
        this.scanner = new Scanner(System.in);
    }

    public void inicio(){
        System.out.println("Agenda de tarefas.");
        int op;
        do{
            mostrarMenu();
            switch (op){
                case 1->
                    System.out.println("Criar uma tarefa.");break;//jfx
                case 2->
                    System.out.println("Comcluir uma tarefa");break;//jfx
                case 3->
                    System.out.println("listar tarefas");break;//jfx
                case 4->
                    System.out.println("listar taferas concluidas");break;//jfx
                case 0->
                    System.out.println("Saindo");break;//jfx
                default->
                    System.out.println("Opção invalida.");
            }
        }while (op!=0);
    }
    private void mostrarMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Cadastrar nova tarefa");
        System.out.println("2 - Alterar status de uma tarefa");
        System.out.println("3 - Ver todas as tarefas");
        System.out.println("4 - Ver tarefas concluídas");
        System.out.println("0 - Sair");
    }

}
