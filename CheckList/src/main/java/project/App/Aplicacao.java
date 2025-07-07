package project.App;

import java.util.Scanner;

public class Aplicacao {
    private final Scanner scanner;

    public menuTarefas(){

    }

    public void inicio(){
        System.out.println("Agenda de tarefas.");
        int op;
        do{

            switch (op){
                case 1:
                    System.out.println("Criar uma tarefa.");break;
                case 2:
                    System.out.println("Comcluir uma tarefa");break;
                case 3:
                    System.out.println("listar tarefas");break;
                case 4:
                    System.out.println("listar taferas concluidas");break;
                case 0:
                    System.out.println("Saindo");break;
                default:
                    System.out.println("Opção invalida.");
            }
        }while (op!=0);
    }
}
