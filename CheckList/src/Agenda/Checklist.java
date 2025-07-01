package Agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void alterarStatus(Tarefa tarefa) {
       if (tarefa.getStatus() == true) {
           tarefa.setStatus(false);
       } else {
           tarefa.setStatus(true);
       }

       tarefa.setDataAlteracao(LocalDateTime.now());
    }

    public void mostrarTarefas(int i) {
       if (i == 1) {
           System.out.println(tarefaList);
       } else if (i == 2) {
           tarefaList.stream().
                   filter(Tarefa::isAtiva).
                   forEach(System.out::println);
       } else {
           tarefaList.stream().
                   filter(Tarefa::isInativa).
                   forEach(System.out::println);
       }
    }

    public List<Tarefa> getTarefaList() {
        return tarefaList;
    }

    @Override
    public String toString() {
        return "\nChecklist:\n" +
                "tarefaList:" + tarefaList +
                '.';
    }
}
