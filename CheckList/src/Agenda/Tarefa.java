package Agenda;

import java.time.LocalDate;
import java.util.Scanner;

public class Tarefa {
    private String texto;
    private Boolean status;
    //    private
    private LocalDate dataInicio;
    private LocalDate dataAlteracao;

    public Tarefa(String texto){
        this.texto = texto;
        this.status = true;//true = ativo
        this.dataInicio = LocalDate.now();
        this.dataAlteracao = LocalDate.now();
    }
    public void criarTarefa(Tarefa tarefa) {
        System.out.println("Tarefa criada:" +
                "\n"+this.texto);
        tarefa.status = true;
        tarefa.dataInicio = LocalDate.now();
        tarefa.dataAlteracao = LocalDate.now();
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "\nChecklist:\n" +
                "Tarefa:'" + texto + '\'' +
                " - status:" + status +
                "\nData de criação:" + dataInicio +
                "\nData da ultima alteraçao:" + dataAlteracao +
                '.';
    }

}
