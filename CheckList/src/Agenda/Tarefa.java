package Agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Tarefa {
    private String texto;
    private Boolean status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataAlteracao;

    public Tarefa(String texto){
        this.texto = texto;
        this.status = true;//true = ativo
        this.dataInicio = LocalDateTime.now();
        this.dataAlteracao = LocalDateTime.now();
    }
    public void criarTarefa(Tarefa tarefa) {
        System.out.println("Tarefa criada:" +
                "\n"+this.texto);
        tarefa.status = true;
        tarefa.dataInicio = LocalDateTime.now();
        tarefa.dataAlteracao = LocalDateTime.now();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
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
