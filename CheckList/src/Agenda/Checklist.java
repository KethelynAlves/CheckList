package Agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Checklist {
   private List<Tarefa> tarefaList;
   public Checklist(){
       this.tarefaList = new ArrayList<>();
   }
    public void adicionarTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva a tarefa: ");
       var novaTarefa = new Tarefa(scanner.nextLine());
       novaTarefa.criarTarefa(novaTarefa);
        this.tarefaList.add(novaTarefa);
    }

    @Override
    public String toString() {
        return "\nChecklist:\n" +
                "tarefaList:" + tarefaList +
                '.';
    }
}
